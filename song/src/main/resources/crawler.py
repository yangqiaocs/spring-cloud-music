import requests
import argparse
import json
import pymysql
import os

parser = argparse.ArgumentParser(description='Process some integers.')
parser.add_argument('--keyword', help='keyword for search')
parser.add_argument('--localLocation', help='localLocation for search')
parser.add_argument('--host', help='host for file')
parser.add_argument('--user', help='user for database')
parser.add_argument('--password', help='password for database')
parser.add_argument('--database', help='database for store')
parser.add_argument('--table', help='table for store')

args = parser.parse_args()


searchUrl = "http://localhost:3300/search?key={}"
r = requests.get(searchUrl.format(args.keyword))
jsonContent = json.loads(r.text)
songList = jsonContent.get('data').get("list")
downloadUrl = "curl http://localhost:3300/song/url?id={}"


def getConn():
    conn = pymysql.connect(host=args.host,
                           user=args.user,
                           password=args.password,
                           database=args.database,
                           cursorclass=pymysql.cursors.DictCursor)

    return conn


conn = getConn()

baseLocation = "/Users/qiao_yang/Desktop/stw/music/songs/"


def downloadSong(url, name, id):
    dir = baseLocation+id+"-"+name
    print("start download {}-{}".format(name, url))
    print(dir)
    if not os.path.exists(dir):
        os.mkdir(dir)
    cmd = "curl {} >> {}/music.mp3".format(url, dir)
    print(cmd)
    os.popen(cmd)
    return "/"+id+"-"+name+"/music.mp3"


for song in songList[2:20]:
    songmid = song.get('songmid')
    songUrl = downloadUrl.format(songmid)
    songr = os.popen(songUrl).read()
    print(json.loads(songr))

    songUrl = json.loads(songr).get('data')
    song_id = song.get('songmid')
    song_name = song.get('songname')
    song_singer = song.get('singer')[0].get('name')
    music_music = downloadSong(songUrl, song_name, song_id)

    conn.ping(reconnect=True)

    with conn:
        with conn.cursor() as cursor:
            # Create a new record
            sql = "insert into song (song_id, song_name,song_singer,music_music) values (%s, %s, %s, %s)"
            cursor.execute(sql, (song_id, song_name, song_singer,
                           music_music))
            conn.commit()

conn.close()
