package com.example.sampleproduct.mapper

import com.example.sampleproduct.model.Member
import org.apache.ibatis.annotations.*

@Mapper
interface MemberMapper {
    @Select("SELECT * FROM member AND status = 1")
    fun getAllMembers(): List<Member>

    @Select("SELECT * FROM member WHERE ID = #{id}")
    fun getMember(id: Long): Member

    @Insert("INSERT INTO member(name, mail_address, password, status) VALUES(#{name}, #{mailAddress}, #{password}, #{status})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    fun insertMember(member: Member)

    @Update("UPDATE member SET name = #{name}, mail_address = #{mailAddress}, password = #{password}, status = #{status} WHERE id = #{id}")
    fun updateMember(member: Member)

    @Delete("DELETE FROM member WHERE id = #{id}")
    fun deleteMember(id: Long)
}