package com.example.lkcare1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MemberAdapter extends RecyclerView.Adapter<MemberAdapter.MemberViewHolder> {

    private List<Member> memberList;
    private Context context;

    public MemberAdapter(List<Member> memberList, Context context) {
        this.memberList = memberList;
        this.context = context;
    }

    @NonNull
    @Override
    public MemberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.member_item, parent, false);
        return new MemberViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MemberViewHolder holder, int position) {
        Member member = memberList.get(position);
        holder.nameTextView.setText(member.getName());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, med_fich.class);
                intent.putExtra("member", member);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return memberList.size();
    }

    public static class MemberViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;

        public MemberViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
        }
    }
}
