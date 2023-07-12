package com.example.sampleproduct.controller

import com.example.sampleproduct.model.Member
import com.example.sampleproduct.service.MemberService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/members")
class MemberController(
    private val memberService: MemberService
) {

    @GetMapping
    fun getAllMembers(): List<Member> {
        return memberService.getAllMembers()
    }

    @GetMapping("/{id}")
    fun getMember(@PathVariable id: Long): ResponseEntity<Member> {
        val member = memberService.getMember(id)
        return ResponseEntity.ok(member)
    }

    @PostMapping("/")
    fun createMember(@RequestBody member: Member): ResponseEntity<Void> {
        memberService.createMember(member)
        return ResponseEntity.status(HttpStatus.CREATED).build()
    }

    @PutMapping("/{id}")
    fun updateMember(
        @PathVariable id: Long,
        @RequestBody member: Member
    ): ResponseEntity<Void> {
        if (id != member.id) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build()
        }
        memberService.updateMember(member)
        return ResponseEntity.status(HttpStatus.OK).build()
    }

    @DeleteMapping("/{id}")
    fun deleteMember(@PathVariable id: Long): ResponseEntity<Void> {
        memberService.deleteMember(id)
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build()
    }
}