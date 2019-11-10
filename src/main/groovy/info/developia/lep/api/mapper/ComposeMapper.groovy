package info.developia.lep.api.mapper

import info.developia.lep.api.model.Compose
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Select


interface ComposeMapper {
    @Select("SELECT * FROM LEP.COMPOSES")
    List<Compose> getAll()

    @Insert("INSERT INTO LEP.COMPOSES(NCAS, NCE, NAME, DESCRIPTION) VALUES( #{ncas} , #{nce} , #{name}, #{description})")
    void addOne(Compose compose)
}
