package br.com.fiap.gs01ocean20

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.gs01ocean20.adapter.ItensAdapter
import br.com.fiap.gs01ocean20.model.ItemModel
import br.com.fiap.gs01ocean20.ui.theme.Gs01ocean20Theme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        //Setando a view principal
        setContentView(R.layout.activity_main);


        //declarando a variavel do recycler view
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView);
        val itensAdapter = ItensAdapter()


        //vinculando o adapter ao recycler view
        recyclerView.adapter = itensAdapter


        //declarando a variavel do botão incluir
        val btnIncluir = findViewById<Button>(R.id.btnIncluir)


        // declarando as variáveis dos editText
        val praiaEditText = findViewById<EditText>(R.id.praiaEditText)
        val cidadeEditText = findViewById<EditText>(R.id.cidadeEditText)
        val estadoEditText = findViewById<EditText>(R.id.estadoEditText)


        //criando a função de inclusão no botão para alimentar o recyclerView
        btnIncluir.setOnClickListener() {


            var validaCampos = false


            //Valida campo praia vazio na inclusão
            if (praiaEditText.text.isEmpty()) {
                praiaEditText.error = "Informe o nome da Praia"
                validaCampos = true
            } else if (praiaEditText.text.length <= 3){
                praiaEditText.error = "Nome praia deve ter no mínimo 3 caracteres"
                validaCampos = true
            }


            //Valida campo cidade vazio na inclusão
            if (cidadeEditText.text.isEmpty()) {
                cidadeEditText.error = "Informe o nome da Cidade"
                validaCampos = true
            } else if (cidadeEditText.text.length < 3){
                cidadeEditText.error = "Nome cidade deve ter no mínimo 3 caracteres"
                validaCampos = true
            }


            //Valida campo cidade vazio na inclusão
            if (estadoEditText.text.isEmpty()) {
                estadoEditText.error = "Informe a sigla do Estado"
                validaCampos = true
            } else if (cidadeEditText.text.length < 2){
                estadoEditText.error = "Nome cidade deve ter no mínimo 2 caracteres"
                validaCampos = true
            }


            if(validaCampos){
                return@setOnClickListener
            }


            val item = ItemModel(
                praia = praiaEditText.text.toString()
                , cidade = cidadeEditText.text.toString()
                , estado = estadoEditText.text.toString()
                , onRemove = {
                    itensAdapter.removeItem(it)
                }
            )


            itensAdapter.addItem(item)


            //limpando campos após inclusao
            praiaEditText.text.clear()
            cidadeEditText.text.clear()
            estadoEditText.text.clear()


        }


    }


}

