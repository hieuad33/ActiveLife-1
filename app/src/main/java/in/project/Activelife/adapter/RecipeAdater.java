package in.project.Activelife.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

import in.project.Activelife.R;
import in.project.Activelife.models_1.RootObjectModel;

public class RecipeAdater extends RecyclerView.Adapter<RecipeAdater.FoodViewHolder> {
    private Context context;
    private ArrayList<RootObjectModel>recipes;
    public RecipeAdater(Context context, ArrayList<RootObjectModel> recipes) {
        this.context = context;
        this.recipes = recipes;
    }
    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view = LayoutInflater.from(context).inflate(R.layout.custom_entries,parent,false);
      return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
    holder.lable.setText("Label:\t"+recipes.get(position).getRecipeModel().getLabel());
    holder.source.setText("Source:\t\t"+recipes.get(position).getRecipeModel().getSource());
    holder.yeild.setText("Yeild:\t"+recipes.get(position).getRecipeModel().getYield());
    holder.calories.setText("Calories:\t"+recipes.get(position).getRecipeModel().getCalories());
    holder.weight.setText("TotalWeight:\t"+recipes.get(position).getRecipeModel().getTotalWeight());
        Glide.with(holder.imageView.getContext()).load(recipes.get(position).getRecipeModel().getImage()).centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.imageView);
    }



    @Override
    public int getItemCount() {
        if(recipes !=null){
            return recipes.size();

        }
        return 0;
    }

    class FoodViewHolder extends RecyclerView.ViewHolder{
        TextView lable,source,yeild,calories,weight;
    ImageView imageView;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            lable = itemView.findViewById(R.id.text_lable);
            source = itemView.findViewById(R.id.text_source);
            yeild = itemView.findViewById(R.id.text_yeild);
            calories = itemView.findViewById(R.id.text_calories);
            weight = itemView.findViewById(R.id.text_weight);
            imageView = itemView.findViewById(R.id.recipeImg);
        }
    }
}