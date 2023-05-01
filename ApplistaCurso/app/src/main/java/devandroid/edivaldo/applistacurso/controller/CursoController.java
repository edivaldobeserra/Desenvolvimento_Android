package devandroid.edivaldo.applistacurso.controller;

import java.util.ArrayList;
import java.util.List;

import devandroid.edivaldo.applistacurso.model.Curso;

public class CursoController {

    public List listCursos;


    public List getListaDeCursos(){

        listCursos= new ArrayList<Curso>();

        listCursos.add(new Curso());
        listCursos.add(new Curso());
        listCursos.add(new Curso());
        listCursos.add(new Curso());
        listCursos.add(new Curso());
        listCursos.add(new Curso());
        listCursos.add(new Curso());

        return listCursos;



    }
}
