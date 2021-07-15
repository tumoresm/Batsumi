import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class StaticRvAdapter extends RecyclerView.Adapter<StaticRvAdapter.StaticRVViewHolder>{
private ArrayList<StaticRvModel> items;
public StaticRvAdapter(ArrayList<StaticRVViewHolder> items){this.items=items;}

@NonNull
@Override
public StaticRVViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.static_rv_item,parent, attachRoot: false);
StaticRVViewHolder staticRVViewHolder = new StaticRVViewHolder(view);
return staticRVViewHolder;

@Override
public void onBindViewHolder(@NonNull StaticRVViewHolder holder, int position) {
StaticRvModel currentItem=items.get(position);
holder.imageView.setImageResource(currentItem.getImage());
holder.textView.setText(currentItem.getText());

@override
public int getItemCount() {
return items.size();
}



public static class StaticRVViewHolder extends RecyclerView.ViewHolder{
TextView textView;
ImageView imageView;

public StaticRVViewHolder(@NonNull View itemView) {super(itemView);
super(itemView);
imageView=itemView.findViewById(R.id.image);
textView=itemView.findViewById(R.id.text);

}
}
}