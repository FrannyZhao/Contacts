package com.microsoft.contacts.UI.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.microsoft.contacts.R;
import com.microsoft.contacts.utilities.ResourceHelper;
import com.microsoft.contacts.UI.view.AutoLocateHorizontalView;
import com.microsoft.contacts.UI.view.AvatarView;
import com.microsoft.contacts.models.PersonalInformation;

import java.util.ArrayList;

/**
 * Created by zhaofengyi on 2018/12/12.
 */

public class AvatarAdapter extends RecyclerView.Adapter<AvatarAdapter.AvatarViewHolder>
        implements AutoLocateHorizontalView.IAutoLocateHorizontalView {
    private Context mContext;
    private ArrayList<PersonalInformation> mPersonalInformations;
    private View mView;
    private OnItemClickedListener mOnItemClickedListener;

    public AvatarAdapter(Context context, ArrayList<PersonalInformation> personalInformations) {
        mContext = context;
        mPersonalInformations = personalInformations;
    }

    @NonNull
    @Override
    public AvatarAdapter.AvatarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mView = LayoutInflater.from(mContext).inflate(R.layout.avatar_viewholder, parent,false);
        return new AvatarViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull final AvatarViewHolder holder, int position) {
        int imageRes = ResourceHelper.getInstance(mContext).getDrawableId(mPersonalInformations.get(position).getAvatarFileName());
        holder.avatarView.setImageResource(imageRes);
        holder.avatarView.setTag(position);
        holder.avatarView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnItemClickedListener != null) {
                    mOnItemClickedListener.onItemClicked((int) holder.avatarView.getTag());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mPersonalInformations == null ? 0 : mPersonalInformations.size();
    }

    @Override
    public View getItemView() {
        return mView;
    }

    @Override
    public void onViewSelected(boolean isSelected, int pos, RecyclerView.ViewHolder holder) {
        AvatarViewHolder avatarViewHolder = (AvatarViewHolder) holder;
        avatarViewHolder.avatarView.setSelected(isSelected);

    }

    public interface OnItemClickedListener {
        void onItemClicked(int position);
    }

    public void setOnItemClickedListener(OnItemClickedListener onItemClickedListener) {
        mOnItemClickedListener = onItemClickedListener;
    }

    static class AvatarViewHolder extends RecyclerView.ViewHolder {
        AvatarView avatarView;
        public AvatarViewHolder(View itemView) {
            super(itemView);
            avatarView = (AvatarView)itemView.findViewById(R.id.avatar_view);
        }
    }
}
