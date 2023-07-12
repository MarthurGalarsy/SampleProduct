package com.example.sampleproduct.service

import com.example.sampleproduct.mapper.MemberMapper
import com.example.sampleproduct.model.Member
import org.springframework.stereotype.Service

@Service
class MemberService(
    private val memberMapper: MemberMapper
) {
    fun getAllMembers(): List<Member> {
        return memberMapper.getAllMembers()
    }

    fun getMember(id: Long): Member {
        return memberMapper.getMember(id)
    }

    fun createMember(member: Member) {
        memberMapper.insertMember(member)
    }

    fun updateMember(member: Member) {
        memberMapper.updateMember(member)
    }

    fun deleteMember(id: Long) {
        memberMapper.deleteMember(id)
    }
}