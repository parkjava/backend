package com.parkjava.service;

import com.parkjava.model.noticeModel;
import com.parkjava.repository.noticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class noticeService {

    @Autowired
    private noticeRepository noticeRepository;

    public List<noticeModel> getAllNotices() {
        return noticeRepository.findAll();
    }

    public noticeModel getNoticeById(Long noticeIndex) {
        return noticeRepository.findById(noticeIndex).orElse(null);
    }

    public noticeModel createNotice(noticeModel notice) {
        return noticeRepository.save(notice);
    }

    public noticeModel updateNotice(Long noticeIndex, noticeModel noticeDetails) {
        noticeModel notice = noticeRepository.findById(noticeIndex).orElse(null);

        if (notice != null) {
            notice.setUserIndex(noticeDetails.getUserIndex());
            notice.setUserName(noticeDetails.getUserName());
            notice.setNoticeTitle(noticeDetails.getNoticeTitle());
            notice.setNoticeContent(noticeDetails.getNoticeContent());
            notice.setNoticeView(notice.getNoticeView());
            notice.setCreateDate(noticeDetails.getCreateDate());
            notice.setUpdateDate(noticeDetails.getUpdateDate());

            return noticeRepository.save(notice);
        }

        return null;
    }

    public void deleteNotice(Long id) {
        noticeRepository.deleteById(id);
    }
}