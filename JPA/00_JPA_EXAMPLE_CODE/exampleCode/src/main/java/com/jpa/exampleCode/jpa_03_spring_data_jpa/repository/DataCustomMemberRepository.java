package com.jpa.exampleCode.jpa_03_spring_data_jpa.repository;

import com.jpa.exampleCode.jpa_03_spring_data_jpa.entity.DataMember;

import java.util.List;

public interface DataCustomMemberRepository {

    List<DataMember> findMemberCustom();
}
