package com.example.alunos.tarefas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class    MainActivity extends AppCompatActivity {

    /* Declaramos um VETOR DINÂMICO(ArrayList) chamado "tarefas para armazenar as tarefas.
       Declaramos ele global na classe para que as tarefas sejam mantidas na memória     */
    private ArrayList <String> tarefas = new ArrayList<>();


    private ArrayAdapter<String> adapter;
    @Override




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Aponta para o 'adapter' os dados que serão mostrados na listView
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,tarefas);

        // Conectamos o ListView ao código Java para podermos "ligá-lo" ao "adapter"
        ListView listView = (ListView)findViewById(R.id.listView);

        // "Ligamos" o 'ListView' ao adapter que vai trazer os dados
        listView.setAdapter(adapter);

        // Usuário clicar mais de uma linha do listView
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        // 'listView.setOnItemLongClickListener(new' aí aperta Ctrl + espaço para autocompletar
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                tarefas.remove(position);
                adapter.notifyDataSetChanged();
                return false;
            }
        });


    }


    // O usuário digita a tarefa e clica no botão, disparando este método ↓
    public void adicionar(View view) {
        // Faz o findViewById do editText da View para "Conectar" ele ao código Java
        EditText editText = (EditText) findViewById(R.id.editText);

        /* Pegamos o conteúdo do editText (.getText) convertemos para uma String Java (.toString)
        e armazenamos a mesma em uma variável String chamada "tarefa" */

        String tarefa = editText.getText().toString();


        // SE A TAREFA NÃO ESTIVER VAZIA
        // Adiciona uma cópia do conteúdo String "tarefa" no nosso vetor "tarefas" por meio do método (.add)
        if (!tarefa.equals("")) {
            tarefas.add(tarefa);


            //Atualizamos a visualização de tarefas (listView) por meio de um tipo de "refresh" no adapter
            adapter.notifyDataSetChanged();

            /* Definimos o texto do editText para uma String vazia.
                        limpando assim o campo */
            editText.setText("");
        }
    }

}
