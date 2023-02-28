package io.sutsaehpeh.aqbp.user.right.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "aqbp_right")
public class Right {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "right_id", nullable = false)
    private Long rightId;

    @Column(name = "right_key", nullable = false, length = 50)
    private String rightKey;

    @Column(name = "right_name", nullable = false, length = 50)
    private String rightName;

    @Column(name = "right_desc", nullable = false, length = 100)
    private String rightDesc;

    @Column(name = "status", nullable = false)
    private Integer status;

    @Column(name = "weight", nullable = false)
    private Integer weight;

    @Column(name = "gmt_created", nullable = false)
    private Date gmtCreated;

    @Column(name = "gmt_modified", nullable = false)
    private Date gmtModified;

    @Column(name = "delete_flag", nullable = false)
    private Long deleteFlag;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Right right = (Right) o;
        return rightId != null && Objects.equals(rightId, right.rightId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}