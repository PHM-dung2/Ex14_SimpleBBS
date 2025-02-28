package SpringBoot.dao;

import SpringBoot.dto.SimpleBbsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SimpleBbsDao implements ISimpleBbsDao {

    @Autowired
    JdbcTemplate template;

    @Override
    public List<SimpleBbsDto> listDao(){
        System.out.println("listDat()");

        String query = "SELECT * FROM simple_bbs ORDER BY id DESC";
        List<SimpleBbsDto> dtos = template.query( query, new BeanPropertyRowMapper<SimpleBbsDto>(SimpleBbsDto.class));

        return dtos;
    } // f end

    @Override
    public SimpleBbsDto viewDao( String id ){
        System.out.println("viewDao()");

        String query = "SELECT * FROM simple_bbs WHERE id = " + id;
        SimpleBbsDto dto = template.queryForObject( query, new BeanPropertyRowMapper<SimpleBbsDto>(SimpleBbsDto.class));

        return dto;
    } // f end

    @Override
    public int writeDao( final String writer, final String title, final String content ){
        System.out.println("writeDao()");

        String query = "INSERT INTO simple_bbs(id, writer, title, content) " +
                "VALUES ( simple_bbs_seq.nextnal, ?, ?, ? )";
        return template.update( query, writer, title, content );
    } // f end

    @Override
    public int deleteDao( final String id ){
        System.out.println("deleteDao()");

        String query = "DELETE FROM simple_bbs where id = ?";
        return template.update( query, Integer.parseInt( id ) );
    } // f end

}
