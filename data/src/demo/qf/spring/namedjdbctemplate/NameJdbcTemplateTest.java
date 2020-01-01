package demo.qf.spring.namedjdbctemplate;

import demo.qf.spring.MusicType;
import demo.qf.spring.Song;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class NameJdbcTemplateTest {
  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(NameJdbcTemplateConfig.class);
    NamedParameterJdbcTemplate namedJdbcTemplate = (NamedParameterJdbcTemplate) context.getBean("namedParameterJdbcTemplate");

    System.out.println("--------- test NamedParameterJdbcTemplate ----------");
    testNamedParameterJdbcTemplate(namedJdbcTemplate);

    System.out.println("--------- test query one object ----------");
    testGetOneObject(namedJdbcTemplate);

    System.out.println("--------- test query list ----------");
    testGetList(namedJdbcTemplate);

    System.out.println("--------- test insert ----------");
    try {
      testInsert(namedJdbcTemplate);
    } catch (ParseException e) {
      e.printStackTrace();
    }

    System.out.println("--------- test delete ----------");
    testDelete(namedJdbcTemplate);

    System.out.println("--------- test update ----------");
    try {
      testUpdate(namedJdbcTemplate);
    } catch (ParseException e) {
      e.printStackTrace();
    }

    System.out.println("--------- test batch----------");
    try {
      testBatch(namedJdbcTemplate);
    } catch (ParseException e) {
      e.printStackTrace();
    }
  }

  private static void testBatch(NamedParameterJdbcTemplate namedJdbcTemplate) throws ParseException {
    String sql = "insert into song(`name`, singer, `type`, album, pub_date_utc) values(:name, :singer, :type, :album, :pubDateUtc)";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");

    BeanPropertySqlParameterSource[] parameterSources = Stream.of(
      new Song("xxx", "yyy", null, MusicType.CLASSIC, simpleDateFormat.parse("2001-09-09")),
      new Song("aaa", "vvv", null, MusicType.OTHER, simpleDateFormat.parse("2011-09-29"))
    ).map(song -> {
      BeanPropertySqlParameterSource parameterSource = new BeanPropertySqlParameterSource(song);
      parameterSource.registerSqlType("type", Types.VARCHAR); // 对于枚举类型，需要将其注册成为varchar类型
      return parameterSource;
    }).toArray(BeanPropertySqlParameterSource[]::new);
    int[] inserted = namedJdbcTemplate.batchUpdate(sql, parameterSources);
    System.out.println("insert " + Arrays.stream(inserted).sum() + " rows");
  }

  private static void testUpdate(NamedParameterJdbcTemplate namedJdbcTemplate) throws ParseException {
    String sql = "update song set pub_date_utc=:pubDateUtc where name=:name";

    MapSqlParameterSource param = new MapSqlParameterSource();
    param.addValue("name", "Canon");
    param.addValue("pubDateUtc", new SimpleDateFormat("yyyy-mm-dd").parse("1654-01-01"));
    int updated = namedJdbcTemplate.update(sql, param);

    System.out.println("update " + updated + " rows");
  }

  private static void testInsert(NamedParameterJdbcTemplate namedJdbcTemplate) throws ParseException {
    String sql = "insert into song(`name`, singer, `type`, album, pub_date_utc) values(:name, :singer, :type, :album, :pubDateUtc)";

    Song song = new Song("Canon", "Johann Pachelbel", null, MusicType.CLASSIC, new SimpleDateFormat("yyyy-mm-dd").parse("1653-01-01"));
    BeanPropertySqlParameterSource parameterSource = new BeanPropertySqlParameterSource(song);
    parameterSource.registerSqlType("type", Types.VARCHAR);// 对于枚举类型，需要将其注册成为varchar类型

    int inserted = namedJdbcTemplate.update(sql, parameterSource);
    System.out.println("insert " + inserted + " rows");
  }

  private static void testDelete(NamedParameterJdbcTemplate namedJdbcTemplate) {
    String sql = "delete from song where name=:name";
    Map<String, Object> param = new HashMap<>();
    param.put("name", "Canon");
    int deleted = namedJdbcTemplate.update(sql, param);

    System.out.println("delete " + deleted + " rows");
  }

  private static void testGetList(NamedParameterJdbcTemplate namedJdbcTemplate) {
    String sql = "select * from song where `type`=:type";

    MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue("type", MusicType.INSTRUMENT, Types.VARCHAR); // MapSqlParameterSource 不直接支持枚举
    List<Song> songs = namedJdbcTemplate.query(sql, params, new RowMapper<Song>() {
      @Override
      public Song mapRow(ResultSet resultSet, int i) throws SQLException {
        Song song = new Song();
        song.setId(resultSet.getInt(Song.FIELD_ID));
        song.setName(resultSet.getString(Song.FIELD_NAME));
        song.setAlbum(resultSet.getString(Song.FIELD_ALBUM));
        song.setSinger(resultSet.getString(Song.FIELD_SINGER));
        song.setType(MusicType.valueOf(resultSet.getString(Song.FIELD_TYPE)));
        song.setPubDateUtc(resultSet.getDate(Song.FIELD_PUB_DATE_UTC));
        song.setRecCreDtUtc(resultSet.getDate(Song.FIELD_REC_CRE_DT_UTC));
        song.setRecUpdDtUtc(resultSet.getDate(Song.FIELD_REC_UPD_DT_UTC));
        return song;
      }
    });
    System.out.println(songs);
  }

  private static void testGetOneObject(NamedParameterJdbcTemplate namedJdbcTemplate) {
    String sql = "select * from song where id=:id";

    Map<String, Integer> params = new HashMap<>();
    params.put("id", 1);
    Song song = namedJdbcTemplate.queryForObject(sql, params, new BeanPropertyRowMapper<>(Song.class));
    System.out.println(song);
  }

  private static void testNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedJdbcTemplate) {
    System.out.println(namedJdbcTemplate);
  }
}
