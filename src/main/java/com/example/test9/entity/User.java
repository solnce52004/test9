package com.example.test9.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "users")
//@Table("users")
@Data
@NoArgsConstructor
@AllArgsConstructor
//@JsonIgnoreProperties(ignoreUnknown = true)
@Accessors(chain = true)
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
//    private Long id;
    private String name;
    private String email;
//    @JsonIgnore
    private String password;

//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
//    @Column("created_at")
//    private LocalDateTime createdAt;
//
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
//    @Column("updated_at")
//    private LocalDateTime updatedAt;

}
