package com.example.myapplication.Cards;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.models.OptionsObject;

import java.util.List;

public class OptionCards extends RecyclerView.Adapter<OptionCards.CardViewHolder> {

    private List<OptionsObject> cardItems;

    public OptionCards(List<OptionsObject> cardItems) {
        this.cardItems = cardItems;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.option_cards, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        OptionsObject item = cardItems.get(position);
        holder.switchItem.setChecked(item.isChecked());
        holder.text1.setText(item.getName());
        holder.text2.setText(item.getServes());
        holder.text3.setText(item.getFunction());

        // Обработка изменения состояния Switch
        holder.switchItem.setOnCheckedChangeListener((buttonView, isChecked) -> {
            item.setChecked(isChecked);
        });
    }

    @Override
    public int getItemCount() {
        return cardItems.size();
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder {
        Switch switchItem;
        TextView text1, text2, text3;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            switchItem = itemView.findViewById(R.id.switch_item);
            text1 = itemView.findViewById(R.id.text1);
            text2 = itemView.findViewById(R.id.text2);
            text3 = itemView.findViewById(R.id.text3);
        }
    }
}
