package com.hanbit.kko.service;

import com.hanbit.kko.domain.MemberBean;

import java.util.ArrayList;

/**
 * Created by hb2012 on 2017-01-07.
 */

public interface MemberService {
    //Read (all. id, group, count), Create, Update, Delete
    //Ctl + d로 복사

    public void regist(MemberBean param);               //createMember
    public ArrayList<MemberBean> list();                    //readAll
    public ArrayList<MemberBean> serachByName(String name); //readGroup
    public MemberBean serachById();                    //readOne
    public boolean login(MemberBean param);           //보안상 bean으로 id,pw전달
    public int count();                               //readCount
    public void modify(MemberBean param);             //updateMember
    public void unregist(String id);                  //deleteMember

}
