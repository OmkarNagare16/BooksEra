package com.example.booksera;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<Product> productList;

        //getting the context and product list with constructor
public ProductAdapter(Context mCtx, List<Product> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
        }

@Override
public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.activity_product_adapter, null);
        return new ProductViewHolder(view);
        }

    @SuppressLint("UseCompatLoadingForDrawables")
@Override
public void onBindViewHolder(ProductViewHolder holder, final int position) {
//getting the product of the specified position
final Product product = productList.get(position);

        //binding the data with the viewholder views

        holder.textViewTitle.setText(product.getTitle());

        //api version not supported
        //holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(product.getImage()));

        holder.cardView.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {

        Intent i = new Intent(v.getContext(), RdbmsPdf.class);
        i.putExtra("title",productList.get(position).getTitle());
        i.putExtra("product",productList.get(position).getTitle());
        i.putExtra("link",productList.get(position).getLink());
        mCtx.startActivity(i);

        }
        });
        }


@Override
public int getItemCount() {
        return productList.size();
        }


class ProductViewHolder extends RecyclerView.ViewHolder {

    TextView textViewTitle;
    ImageView imageView;
    CardView cardView;

    public ProductViewHolder(View itemView) {
        super(itemView);
        cardView = itemView.findViewById(R.id.cardview);// card intial
        textViewTitle = itemView.findViewById(R.id.textViewTitle);
        imageView = itemView.findViewById(R.id.imageView);
    }
}
}