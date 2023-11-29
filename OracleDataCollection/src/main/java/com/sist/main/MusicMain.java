package com.sist.main;

import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.sist.dao.*;

public class MusicMain {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      MusicDAO dao=new MusicDAO();
      try
      {
         Document doc=Jsoup.connect("https://www.genie.co.kr/chart/top200").get();
         Elements title=doc.select("table.list-wrap td.info a.title");
         Elements singer=doc.select("table.list-wrap td.info a.artist");
         Elements album=doc.select("table.list-wrap td.info a.albumtitle");
         Elements poster=doc.select("table.list-wrap a.cover img");
         
         for(int i=0;i<title.size();i++)
         {
            MusicVO vo=new MusicVO();
            vo.setTitle(title.get(i).text());
            vo.setSinger(singer.get(i).text());
            vo.setAlbum(album.get(i).text()); // 태그 안이면 text()
            vo.setPoster(poster.get(i).attr("src")); // 태그 밖이면 attr 
            dao.musicInsert(vo);
         }
         System.out.println("Save End...");
      }catch(Exception ex) {}
   }

}