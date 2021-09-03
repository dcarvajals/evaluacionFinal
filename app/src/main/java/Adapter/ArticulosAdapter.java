package Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;

import com.example.evaluacionfinal.Articulos;
import com.example.evaluacionfinal.R;
import com.example.evaluacionfinal.ViewWeb;
import com.mindorks.placeholderview.PlaceHolderView;

import java.util.List;

import Model.Articulo;
import Model.Revista;
import Model.Volumen;

public class ArticulosAdapter extends PlaceHolderView.Adapter<ArticulosAdapter.ArticulosViewHolder>{

    private Context ctx;
    private List<Articulo> lista_articulo;

    public ArticulosAdapter (Context mCtx, List<Articulo> articulo) {
        this.lista_articulo = articulo;
        this.ctx = mCtx;
    }

    @NonNull
    @Override
    public ArticulosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View view = inflater.inflate(R.layout.cv_articulos, null);
        return new ArticulosAdapter.ArticulosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticulosViewHolder holder, int position) {
        Articulo articulo = lista_articulo.get(position);

        holder.titulo.setText(articulo.getTitle());
        holder.resumen.setText(articulo.getAbstractx());
        holder.autores.setText(articulo.getAuthors());
        holder.palabrasclaves.setText(articulo.getKeywords());
        holder.doi.setText(articulo.getDoi());

        holder.setOnClickListener();

    }

    @Override
    public int getItemCount() {
        return lista_articulo.size();
    }

    class ArticulosViewHolder extends PlaceHolderView.ViewHolder implements View.OnClickListener {

        TextView titulo, resumen, autores, palabrasclaves, doi;
        CardView cv_articulo;
        Context context;
        Button btn_html;

        public ArticulosViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            titulo = itemView.findViewById(R.id.tv_nombre);
            resumen = itemView.findViewById(R.id.tv_resumen);
            autores = itemView.findViewById(R.id.tv_autores);
            palabrasclaves = itemView.findViewById(R.id.tv_palclaves);
            cv_articulo = itemView.findViewById(R.id.cv_articulo);
            doi = itemView.findViewById(R.id.tv_doi);
            btn_html = itemView.findViewById(R.id.btn_html);
        }

        void setOnClickListener () {
            btn_html.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(v.getId() == R.id.btn_html){
                String _url = doi.getText().toString();
                Uri doi = Uri.parse(_url);
                Intent intent = new Intent(Intent.ACTION_VIEW, doi);
                context.startActivity(intent);

                /*Intent intent = new Intent(context, ViewWeb.class);
                intent.putExtra("doi", doi.getText());
                context.startActivity(intent);
                Log.i("LogsEF", "CARGAR PAGINA: " + doi.getText());*/
            }
        }
    }

}
