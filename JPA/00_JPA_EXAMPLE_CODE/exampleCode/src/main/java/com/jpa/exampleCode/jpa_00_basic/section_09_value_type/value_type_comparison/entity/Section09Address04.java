package com.jpa.exampleCode.jpa_00_basic.section_09_value_type.value_type_comparison.entity;


import lombok.Getter;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@Getter
public class Section09Address04 {

        private String city;
        private String street;
        private String zipcode;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Section09Address04 that = (Section09Address04) o;
        return Objects.equals(getCity(), that.getCity()) &&
                Objects.equals(getStreet(), that.getStreet()) &&
                Objects.equals(getZipcode(), that.getZipcode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCity(), getStreet(), getZipcode());
    }
}
