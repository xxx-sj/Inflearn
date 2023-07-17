package com.jpa.exampleCode.jpa_basic_00.section_10_oop_query_language_basic.jpql_function.dialect;

import org.hibernate.dialect.H2Dialect;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.type.StandardBasicTypes;

public class Section10MyH2Dialect extends H2Dialect {
    public Section10MyH2Dialect() {
        registerFunction("group_concat", new StandardSQLFunction("group_concat", StandardBasicTypes.STRING));
    }
}
