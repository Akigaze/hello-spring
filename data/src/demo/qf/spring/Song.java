package demo.qf.spring;

import java.util.Date;

public class Song {
  public static final String FIELD_ID = "id";
  public static final String FIELD_NAME = "name";
  public static final String FIELD_SINGER = "singer";
  public static final String FIELD_ALBUM = "album";
  public static final String FIELD_TYPE = "type";
  public static final String FIELD_PUB_DATE_UTC = "pub_date_utc";
  public static final String FIELD_REC_CRE_DT_UTC = "rec_cre_dt_utc";
  public static final String FIELD_REC_UPD_DT_UTC = "rec_upd_dt_utc";

  private Integer id;
  private String name;
  private String singer;
  private String album;
  private MusicType type;
  private Date pubDateUtc;
  private Date recCreDtUtc;
  private Date recUpdDtUtc;

  public Song() {
  }

  public Song(String name, String singer, String album, MusicType type, Date pubDateUtc) {
    this.name = name;
    this.singer = singer;
    this.album = album;
    this.type = type;
    this.pubDateUtc = pubDateUtc;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setSinger(String singer) {
    this.singer = singer;
  }

  public void setAlbum(String album) {
    this.album = album;
  }

  public void setType(MusicType type) {
    this.type = type;
  }

  public void setPubDateUtc(Date pubDateUtc) {
    this.pubDateUtc = pubDateUtc;
  }

  public void setRecCreDtUtc(Date recCreDtUtc) {
    this.recCreDtUtc = recCreDtUtc;
  }

  public void setRecUpdDtUtc(Date recUpdDtUtc) {
    this.recUpdDtUtc = recUpdDtUtc;
  }

  @Override
  public String toString() {
    return "Song{" +
      "id=" + id +
      ", name='" + name + '\'' +
      ", singer='" + singer + '\'' +
      ", album='" + album + '\'' +
      ", type=" + type +
      ", pubDateUtc=" + pubDateUtc +
      ", recCreDtUtc=" + recCreDtUtc +
      ", recUpdDtUtc=" + recUpdDtUtc +
      '}';
  }
}
