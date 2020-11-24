package com.example.hungryfood;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ViewAllRecipiesAdapter extends BaseAdapter {
    ProgressDialog progressDialog;
    List<GetRecipePojo> getRecipePojos;
    Context cnt;
    public ViewAllRecipiesAdapter(List<GetRecipePojo> ar, Context cnt)
    {
        this.getRecipePojos=ar;
        this.cnt=cnt;
    }
    @Override
    public int getCount() {
        return getRecipePojos.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int pos, View view, ViewGroup viewGroup)
    {
        LayoutInflater obj1 = (LayoutInflater)cnt.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View obj2=obj1.inflate(R.layout.list_view_all_recipies,null);

        TextView tv_recipe_name=(TextView)obj2.findViewById(R.id.tv_recipe_name);
        tv_recipe_name.setText("Recipe Name :"+getRecipePojos.get(pos).getName());

        TextView tv_category=(TextView)obj2.findViewById(R.id.tv_category);
        tv_category.setText("Recipe Category :"+getRecipePojos.get(pos).getCategory());



        TextView tv_recipe_description=(TextView)obj2.findViewById(R.id.tv_recipe_description);
        tv_recipe_description.setText("Recipe Description :"+getRecipePojos.get(pos).getDescription());

        return obj2;
    }

}