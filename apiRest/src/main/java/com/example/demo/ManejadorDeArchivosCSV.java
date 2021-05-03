package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

@Service
public class ManejadorDeArchivosCSV {

    private String ubicacionArchivo;
    private String nombreDeArchivo;
    private char separador;

    public ManejadorDeArchivosCSV() {
        this.ubicacionArchivo = "src/main/resources/files/";
        this.nombreDeArchivo = "trigo.csv";
        this.separador = ',';
    }

    public CSVParser formatearSeparador(){
        CSVParserBuilder puntoYcomaBuilder = new CSVParserBuilder();
        puntoYcomaBuilder = puntoYcomaBuilder.withSeparator(separador);
        CSVParser parser = puntoYcomaBuilder.build();
        return parser;
    }

    public FileReader obtenerArchivo(){
        FileReader reader = null;
        try {
            reader = new FileReader(ubicacionArchivo + nombreDeArchivo);
        } catch (FileNotFoundException e) {
            String mensaje = "Archivo no encontrado, verifique el nombre y/o la ubicación del mismo";
            System.out.println(mensaje);
            e.printStackTrace();
        }
        return reader;
    }

    public CSVReader obtenerArchivoFormateado(){
        FileReader fileReader = this.obtenerArchivo();
        CSVReaderBuilder readerBuilder = new CSVReaderBuilder(fileReader);
        CSVParser separadorFormateado = this.formatearSeparador();
        readerBuilder = readerBuilder.withCSVParser(separadorFormateado);
        CSVReader reader = readerBuilder.build();
        return reader;
    }

    public Iterator<String[]> obtenerIterador(){
        CSVReader reader = this.obtenerArchivoFormateado();
        Iterator<String[]> iterador = reader.iterator();
        return iterador;
    }

    public void imprimirDatosConEspacios() throws FileNotFoundException {

        CSVReader reader = this.obtenerArchivoFormateado();
        Iterator<String[]> iterador = reader.iterator();

        while (iterador.hasNext()){
            String[] fila = iterador.next();
            String filaInfo = fila[0] + " " + fila[1] + " " + fila[2] + " " + fila[3] + " " + fila[4];
            System.out.println(filaInfo);

        }
    }

    public HashMap<String,Object> obtenerHashMapConInfo(){

        CSVReader reader = this.obtenerArchivoFormateado();
        Iterator<String[]> iterador = reader.iterator();
        HashMap<String,Object> informacion = new HashMap<>();
        ArrayList<Trigo> trigoSerie = new ArrayList<>();

        while (iterador.hasNext()){
            String[] fila = iterador.next();

            int indice_tiempo = Integer.parseInt(fila[0]);
            int superficie_sembrada_trigo_ha = Integer.parseInt(fila[1]);
            int superficie_cosechada_trigo_ha  = Integer.parseInt(fila[2]);
            int produccion_trigo_t = Integer.parseInt(fila[3]);
            int rendimiento_trigo_kgxha = Integer.parseInt(fila[4]);

            Trigo trigo = new Trigo(indice_tiempo,superficie_sembrada_trigo_ha,superficie_cosechada_trigo_ha,produccion_trigo_t,rendimiento_trigo_kgxha);
            trigoSerie.add(trigo);
        }

        informacion.put("trigos",trigoSerie);

        return informacion;

    }

    public static void main(String[] args){
        ManejadorDeArchivosCSV m = new ManejadorDeArchivosCSV();


    }

}
