package interviews.sp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlaylistTest {

    private static class Song {
        private String name;
        private String author;

        Song(String name,String author) {
            this.name = name;
            this.author = author;
        }

        @Override
        public String toString() {
            return "Song{" +
                    "name='" + name + '\'' +
                    ", author='" + author + '\'' +
                    '}';
        }
    }

    private static class Playlist{
        private List<Song> list = new ArrayList<>();

        public Playlist(List<Song> list) {
            this.list = list;
        }

        void add(int pos, List<Song> songs){
            list.addAll(pos,songs);
        }

        void remove(int pos, int count){
            List<Song> newlist= new ArrayList<>(list.subList(0,pos));
            newlist.addAll(list.subList(pos + count,list.size()));
            list = newlist;

        }

        void update(int pos, Song song) {
            list.remove(pos);
            list.add(pos,song);
        }

        void swap(int pos, int count, int target){
            List<Song> head = list.subList(0,target );
            List<Song> mid  = list.subList(target,pos);
            List<Song> tail = list.subList(pos + count ,list.size());

            List<Song> newList = new ArrayList<>(head);

            int curr = 0 ;
            int currOffSet = target;

            while(curr < count){

                newList.add(currOffSet,list.get(pos + curr));
                curr++;
                currOffSet++;

            }

            newList.addAll(mid);
            newList.addAll(tail);
            list = newList;
        }

        @Override
        public String toString() {
            list.forEach(System.out::println);
            return "";
        }
    }



    public static void main(String[] args) {

        List<Song> list = new ArrayList<>();
        list.add(new Song("song 1", "author 1"));


        list.add(new Song("song 2", "author 2"));
        list.add(new Song("song 3", "author 3"));
        list.add(new Song("song 4", "author 4"));

        list.add(new Song("song 5", "author 5"));
        list.add(new Song("song 6", "author 6"));
        list.add(new Song("song 7", "author 7"));
        list.add(new Song("song 8", "author 8"));
        list.add(new Song("song 9", "author 9"));
        list.add(new Song("song 10", "author 10"));

        Playlist pl = new Playlist(list);

//        List<Song> newSongs = new ArrayList<>();
//        newSongs.add(new Song("abc","abc"));
//        newSongs.add(new Song("de2","de2"));
//        pl.add(4,newSongs);

//        pl.remove(2,4);

//        pl.update(4,new Song("hello","hello"));

        pl.swap(5,2,2);
        System.out.println(pl);
    }
}
