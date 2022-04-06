package com.example.adp_39_eccomerce.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adp_39_eccomerce.Models.Product;
import com.example.adp_39_eccomerce.R;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private List<Product> productList;
//    private Context context;
    public ProductAdapter(List<Product> productList) {
        this.productList = productList;
//        this.context = context;
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent,
                                                        int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.products, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull ProductAdapter.ViewHolder holder, int position) {
        int img = productList.get(position).getImage();
        String title = productList.get(position).getTitle();
        int price = productList.get(position).getPrice();
        String description = productList.get(position).getDescription();
        String category = productList.get(position).getCategory();

        holder.setData(img, title, price, description, category);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgVal;
        private TextView titleVal, priceVal, descriptionVal, categoryVal;

        public ViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);

            imgVal = itemView.findViewById(R.id.img);
            titleVal = itemView.findViewById(R.id.title);
            priceVal = itemView.findViewById(R.id.price);
            descriptionVal = itemView.findViewById(R.id.description);
            categoryVal = itemView.findViewById(R.id.category);
        }

        public void setData(int img, String title, int price, String description, String category) {
            imgVal.setImageResource(img);
            titleVal.setText(title);
            priceVal.setText(price);
            descriptionVal.setText(description);
            categoryVal.setText(category);
        }
    }
}
