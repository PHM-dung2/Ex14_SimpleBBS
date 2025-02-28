package SpringBoot.dao;

import SpringBoot.dto.SimpleBbsDto;

import java.util.List;

public interface ISimpleBbsDao {

    public List<SimpleBbsDto> listDao();
    public SimpleBbsDto viewDao(String id);
    public int writeDao(String writer, String title, String contenr );
    public int deleteDao(String id);
}
