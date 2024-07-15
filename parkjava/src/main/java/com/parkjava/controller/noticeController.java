package com.parkjava.controller;
import com.parkjava.model.noticeModel;
import com.parkjava.repository.noticeRepository;
import com.parkjava.service.noticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/notice")
public class noticeController {

    @Autowired
    private noticeService noticeService;

    @Autowired
    private noticeRepository noticerepository;

    // 공지 전체 최신순
    @GetMapping
    public List<noticeModel> noticeSearchDESCAll() {
        return noticerepository.noticeSearchDESCAll();
    }

    // 공지 전체 과거순
    @GetMapping("/asc")
    public List<noticeModel> noticeSearchASCAll() {
        return noticerepository.noticeSearchASCAll();
    }

    // 공지 인덱스 상세
    @GetMapping("/index/{noticeIndex}")
    public noticeModel noticeSearchIndex(@PathVariable("noticeIndex") Long noticeIndex, String noticeView) {
        return noticerepository.noticeSearchIndex(noticeIndex);
    }

    @GetMapping("/{id}")
    public ResponseEntity<noticeModel> getUserById(@PathVariable Long id) {
        noticeModel test = noticeService.getNoticeById(id);
        if (test == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(test);
    }

    // 공지 제목으로 검색
    @GetMapping("/title/{noticeTitle}")
    public List<noticeModel> noticeSearchTitle(@PathVariable("noticeTitle") String noticeTitle) {
        return noticerepository.noticeSearchTitle(noticeTitle);
    }

    // 작성자 이름으로 검색
    @GetMapping("/name/{adminName}")
    public List<noticeModel> noticeSearchName(@PathVariable("adminName") String adminName) {
        return noticerepository.noticeSearchName(adminName);
    }

    // 공지 생성
    @PostMapping("/create")
    public noticeModel createNotice(@RequestBody noticeModel notice) {
        return noticeService.createNotice(notice);
    }

    // 공지 수정
    @PutMapping("/update/{noticeIndex}")
    public ResponseEntity<noticeModel> updateNotice(@PathVariable Long noticeIndex, @RequestBody noticeModel noticeDetails) {
        noticeModel updatedTest = noticeService.updateNotice(noticeIndex, noticeDetails);
        if (updatedTest == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedTest);
    }

    // 공지 삭제
    @DeleteMapping("/delete/{noticeIndex}")
    public ResponseEntity<Void> deleteNotice(@PathVariable Long noticeIndex) {
        noticeService.deleteNotice(noticeIndex);
        return ResponseEntity.noContent().build();
    }

    // 공지 제목 오름차순 정렬
    @GetMapping("/title/asc")
    public List<noticeModel> noticeTitleAscAll() {
        return noticerepository.noticeTitleAscAll();
    }

    // 공지 제목 내림차순 정렬
    @GetMapping("/title/desc")
    public List<noticeModel> noticeTitleDescAll() {
        return noticerepository.noticeTitleDescAll();
    }
    // 공지 조회수 오름차순
    @GetMapping("/view/asc")
    public List<noticeModel> noticeViewAscAll() {
        return noticerepository.noticeViewAscAll();
    }

    // 공지 조회수 내림차순
    @GetMapping("/view/desc")
    public List<noticeModel> noticeViewDescAll() {
        return noticerepository.noticeViewDescAll();
    }

    // 공지 페이징
    // offset = X번째 인덱스(offset) 부터 limit = 조회할 목록의 갯수(limit),
    // ex) limit = 30 offset = 0 이면 조회한 데이터 0번 에서 30개까지 조회
    @GetMapping("/paginate/{limit}/{offset}")
    public  List<noticeModel> noticePaginate(@PathVariable("limit") Integer limit, @PathVariable("offset") Integer offset) {
        return noticerepository.noticePaginate(limit, offset);
    }
}