package com.example.toy.src.post.entity;

import com.example.toy.src.user.entity.User;
import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DynamicInsert
@Table(name = "post")
public class Post {

    @Id
    @Column(name = "post_idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "post_title")
    @NotNull
    private String title;

    @Column(name = "post_content")
    private String content;


    @Column(name = "board_idx")
    private Long board_idx;

    @Column(name = "is_blind", columnDefinition = "tinyint default 1")
    private Byte is_blind;

    @Column(name = "status", columnDefinition = "tinyint default 1")
    private Byte status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="user_idx")//FK
    @NotNull
    private User user;

//    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
//    private List<Post> postList = new ArrayList<>();


    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }

}