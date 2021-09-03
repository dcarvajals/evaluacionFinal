package Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;

import com.bumptech.glide.Glide;
import com.example.evaluacionfinal.Articulos;
import com.example.evaluacionfinal.R;
import com.mindorks.placeholderview.PlaceHolderView;

import java.util.List;

import Model.Articulo;
import Model.Revista;
import Model.Volumen;

public class VolumenAdapter extends PlaceHolderView.Adapter<VolumenAdapter.VolumenViewHolder> {

    private Context ctx;
    private List<Volumen> lista_volumen;

    public VolumenAdapter (Context mCtx, List<Volumen> volumen) {
        this.lista_volumen = volumen;
        this.ctx = mCtx;
    }

    @NonNull
    @Override
    public VolumenViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View view = inflater.inflate(R.layout.cv_volumenes, null);
        return new VolumenAdapter.VolumenViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VolumenViewHolder holder, int position) {
        Volumen volumen = lista_volumen.get(position);

        holder.title.setText(volumen.getTitle());
        holder.date_published.setText(volumen.getDate_published());
        holder.volume.setText(volumen.getVolume());
        holder.year.setText(volumen.getYear());
        holder.doi.setText(volumen.getDoi());
        holder.tv_id.setText(volumen.getIssue_id());

        holder.setOnClickListener();

        Glide.with(ctx)
                .load(volumen.getCover())
                .into(holder.cover);

    }

    @Override
    public int getItemCount() {
            return lista_volumen.size();
    }

    class VolumenViewHolder  extends PlaceHolderView.ViewHolder implements View.OnClickListener {

        TextView volume, year, date_published, title, doi, tv_id;
        ImageView cover;
        CardView cv_volumen;
        Button btn_enlistararticulos;
        Context context;

        public VolumenViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            tv_id = itemView.findViewById(R.id.tv_id);
            title = itemView.findViewById(R.id.tv_titulo_revista);
            cover = itemView.findViewById(R.id.iv_covervol);
            date_published = itemView.findViewById(R.id.tv_fecha_publicacion);
            year = itemView.findViewById(R.id.tv_anio);
            volume = itemView.findViewById(R.id.tv_volumen);
            doi = itemView.findViewById(R.id.tv_doi);
            btn_enlistararticulos = (Button)  itemView.findViewById(R.id.btn_enlistararticulos);
            cv_volumen = itemView.findViewById(R.id.cv_volumen);
        }
        void setOnClickListener () {
            btn_enlistararticulos.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(v.getId() == R.id.btn_enlistararticulos){
                Intent intent = new Intent(context, Articulos.class);
                intent.putExtra("idarticulo", tv_id.getText());
                context.startActivity(intent);
                Log.i("LogsEF", "CARGAR ARTICULOS DEL VOLUMEN CON ID: " + tv_id.getText());
            }
        }
    }

}
