package com.hanbit.kko.service;

import com.hanbit.kko.domain.MessageBean;

import java.util.ArrayList;

/**
 * Created by hb2012 on 2017-01-07.
 */

public interface MessageService {
    public void write(MessageBean msg);         //createMaessge
    public ArrayList<MessageBean> list();
    public ArrayList<MessageBean> findByWriter(String id);
    public MessageBean findBySeq(int seq);
    public int count();
    public int countByWriter(String id);
    public void updateMessage(MessageBean msg);
    public void deleteMessage(int seq);
}
