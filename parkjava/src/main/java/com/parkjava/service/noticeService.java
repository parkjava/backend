package com.parkjava.service;

import com.parkjava.model.noticeModel;
import com.parkjava.repository.noticeRepository;
import org.hibernate.annotations.CurrentTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class noticeService {

    @Autowired
    private noticeRepository noticeRepository;

    public List<noticeModel> getAllNotices() {
        return noticeRepository.findAll();
    }
    public noticeModel getNoticeById(long noticeIndex) {
        noticeModel notice = noticeRepository.findById(noticeIndex).orElse(null);
        if (notice != null) {
            notice.setNoticeView(notice.getNoticeView()+1);
            noticeRepository.save(notice);
        }
        return noticeRepository.findById(noticeIndex).orElse(null);
    }

    public noticeModel createNotice(noticeModel notice) {
        return noticeRepository.save(notice);
    }

    public noticeModel updateNotice(Long noticeIndex, noticeModel noticeDetails) {
        noticeModel notice = noticeRepository.findById(noticeIndex).orElse(null);

        if (notice != null) {
            notice.setNoticeTitle(noticeDetails.getNoticeTitle());
            notice.setNoticeContent(noticeDetails.getNoticeContent());
            // 현재 날짜와 시간 설정, 날짜/시/분 형식
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            String formattedDateTime = LocalDateTime.now().format(formatter);
            notice.setUpdateDate(formattedDateTime);
            return noticeRepository.save(notice);
        }

        return null;
    }

    public void deleteNotice(Long noticeIndex) {
        noticeRepository.deleteById(noticeIndex);
    }
}