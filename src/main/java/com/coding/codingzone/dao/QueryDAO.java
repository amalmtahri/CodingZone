package com.coding.codingzone.dao;

public final class QueryDAO {

    public static final String INSERT_CATEGORY = "INSERT INTO categorie(id, name, image) VALUES (?, ?, ?)";
    public static final String SELECT_CATEGORY = "SELECT * FROM categorie";
    public static final String DELETE_CATEGORY = "delete from categorie where id = ?";
    public static final String GETONE_CATEGORY = "select * from categorie where id = ?";
    public static final String UPDATE_CATEGORY = "update  categorie set name = ?, image = ? where id = ? ";
    public static final String CATEGORY_QUIZ_COUNT = "SELECT c.name ,c.image , count(*),sum(q.timelimit) from categorie c , question q , questtest qt , quiz where c.id =q.categorie_id and qt.question_id = q.id and quiz.test_id = qt.test_id and quiz.code = ? group by c.id";


    public static final String INSERT_QUESTION = "insert into question(id,question, response, choice1, choice2, choice3, timelimit, categorie_id, score) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String SELECT_QUESTION = "select q.*, c.id, c.name, c.image from question q, categorie c where q.categorie_id = c.id";
    public static final String DELETE_QUESTION = "delete from question where id = ?";
    public static final String GETONE_QUESTION = "select q.*, c.id, c.name, c.image from question q, categorie c where q.categorie_id = c.id and q.id = ?";
    public static final String UPDATE_QUESTION = "update question set question = ?, response = ?, choice1 = ?, choice2 = ?, choice3 = ?, timelimit = ?, categorie_id = ?, score = ? where id = ?";

    //CRUD TEST
    public static final String INSERT_TEST = "insert into test(id, name) values (?, ?)";
    public static final String SELECT_TEST = "select * from test";
    public static final String DELETE_TEST = "delete from test where id = ?";
    //affect question test
    public static final String INSERT_QUESTIONS_TEST = "insert into questtest (test_id, question_id) values (?, ?)";
    //affect quiz
    public static final String INSERT_QUIZ = "insert into quiz(id, code, test_id, candidat_id, staff_id) values(?, ?, ?, ?, ?)";
    public static final String SHOW_QUESTIONS =  " SELECT qs.* , c.* from quiz q ,question qs , test t , questtest qt , categorie c where t.id = q.test_id and qt.test_id = t.id and qt.question_id = qs.id and c.id = qs.categorie_id and q.code = ? ";

    public static final String INSERT_RESULTQUIZ ="INSERT INTO resultquiz(id,score,quiz_id)VALUES(?,?,(SELECT q.id FROM  quiz q WHERE  q.code = ?))";


    //get All candidat

    public static final String SELECT_EMAIL_CANDIDAT = "select c.*, p.* from candidat c, person p where c.person_id = p.id and c.id = ?";

    //Check id test deja passé
    public static final String CHECK_QUIZ = "SELECT * FROM resultquiz where quiz_id in (select id from quiz where code = ? )";
    public static final String MAJ_SCORE = "UPDATE resultquiz set score = score + ? where quiz_id in (select id from quiz where code = ? )";


    //Candidat
    public static final String INSERT_PERSON =  "insert into person (id,firstname,lastname,email)values(?,?,?,?)";
    public static final String INSERT_CANDIDAT = "insert into candidat(id,person_id)values(?,?)";
    public static final String SELECT_CANDIDAT = "select c.*, p.* from candidat c, person p where c.person_id = p.id";
    public static final String FIND_CANDIDAT = "select c.*, p.* from candidat c, person p where c.person_id = p.id and c.id=?";
    public static final String DELETE_CANDIDAT = "delete from candidat where id = ?";
    public static final String DELETE_PERSON = "delete from person where id = ?";
    public static final String UPDATE_CANDIDAT = "update person set firstname = ?, lastname = ?, email = ? where id = ?";


    public static final String CHECK_QUIZ_EXIST ="SELECT * FROM quiz WHERE code = ?";

}
