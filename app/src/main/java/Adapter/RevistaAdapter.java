package Adapter;

import android.content.Context;
import android.content.Intent;
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
import com.example.evaluacionfinal.R;
import com.example.evaluacionfinal.Volumenes;
import com.mindorks.placeholderview.PlaceHolderView;

import java.util.List;

import Model.Revista;

public class RevistaAdapter extends PlaceHolderView.Adapter<RevistaAdapter.RevistaViewHolder> {

    private Context ctx;
    private List<Revista> lista_revistas;

    public RevistaAdapter(Context mCtx, List<Revista> revistas) {
        this.lista_revistas = revistas;
        this.ctx = mCtx;
    }

    @Override
    public RevistaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View view = inflater.inflate(R.layout.card_view, null);
        return new RevistaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RevistaViewHolder holder, int position) {
        Revista revista = lista_revistas.get(position);

        holder.id_journal.setText(revista.getJournal_id());
        holder.nombre.setText(revista.getName());
        holder.abreviation.setText(revista.getAbbreviation());

        holder.setOnClickListener();

        Glide.with(ctx)
                .load(revista.getPortada())
                .into(holder.cover);

    }

    @Override
    public int getItemCount() {
        return lista_revistas.size();
    }

    class RevistaViewHolder extends PlaceHolderView.ViewHolder implements View.OnClickListener {
        TextView description, nombre, abreviation, id_journal;
        ImageView cover;
        CardView cv_lista;
        Button enlistar_volumnes;
        Context context;

        public RevistaViewHolder(View itemView) {
            super(itemView);

            context = itemView.getContext();

            id_journal = itemView.findViewById(R.id.tv_journalid);
            nombre = itemView.findViewById(R.id.tv_nombre);
            abreviation = itemView.findViewById(R.id.tv_abreviation);
            cover = itemView.findViewById(R.id.iv_cover);
            enlistar_volumnes = (Button) itemView.findViewById(R.id.btn_enllistarvollumenes);
            cv_lista = itemView.findViewById(R.id.cv_lista);

        }

        void setOnClickListener () {
            enlistar_volumnes.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(v.getId() == R.id.btn_enllistarvollumenes){
                Intent intent = new Intent(context, Volumenes.class);
                intent.putExtra("idrevista", id_journal.getText());
                context.startActivity(intent);
                Log.i("LogsEF", "CARGAR VOLUMENES DE LA REVISTA CON ID: " + id_journal.getText());
            }
        }
    }
}


