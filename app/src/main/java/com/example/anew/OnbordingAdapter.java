package com.example.anew;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

class OnboardingAdapter extends RecyclerView.Adapter<OnboardingAdapter.BoardingViewHolder> {

    private final List<OnboardingItem> onboardItems;

    public OnboardingAdapter(List<OnboardingItem> onboardingItems) {
        this.onboardItems = onboardingItems;
    }

    @NonNull
    @Override
    public BoardingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BoardingViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_container_onbording, parent, false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull BoardingViewHolder holder, int position) {
        holder.setBoardingData(onboardItems.get(position));

    }

    @Override
    public int getItemCount() {
        return onboardItems.size();
    }

     static class BoardingViewHolder extends RecyclerView.ViewHolder{
        private  TextView textTitle;
        private  TextView textDescription;
        private  ImageView imageOnboarding;

        BoardingViewHolder(@NonNull View itemView) {
            super(itemView);
            textTitle=itemView.findViewById(R.id.textTitle);
            textDescription=itemView.findViewById(R.id.textDescription);
            imageOnboarding= itemView.findViewById(R.id.imageOnboarding);

        }

        void setBoardingData(OnboardingItem onboardingItem){
            textTitle.setText(onboardingItem.getTitle() );
            textDescription.setText(onboardingItem.getDescription());
           imageOnboarding.setImageResource(onboardingItem.getImage());

        }
    }
}
