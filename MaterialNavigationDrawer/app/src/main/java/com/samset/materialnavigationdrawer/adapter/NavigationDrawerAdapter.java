package com.samset.materialnavigationdrawer.adapter;

import android.app.Activity;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.samset.materialnavigationdrawer.R;
import com.samset.materialnavigationdrawer.listeners.OnItemClickListener;


public class NavigationDrawerAdapter extends
        RecyclerView.Adapter<NavigationDrawerAdapter.MyHolderView> {
    public static final int CAMERA = 1;
    public static final int GALLERY = 2;
    static String listItem[];
    String listItemSec[];
    String profile_name;
    int listIcon[];
    int listIconSec[];
    int profile;
    static Activity context;
    final static int VIEW_TYPE_HEADER = 0;
    final static int VIEW_TYPE_ITEM = 1;
    final static int VIEW_TYPE_FOOTER = 2;
    MyHolderView myholder;
    private static OnItemClickListener listener;

    public OnItemClickListener getListner() {
        return listener;
    }

    public void setListner(OnItemClickListener listner) {
        this.listener = listner;
    }


    public NavigationDrawerAdapter(Activity ctx,String title[], int icons[], String username, int icon) {
        this.context = ctx;
        this.listIcon = icons;
        this.listItem = title;
        this.profile_name = username;
        this.profile = icon;

    }


    public static class MyHolderView extends RecyclerView.ViewHolder
    {
        public static int Holderid;

        LinearLayout header_viewprofile;
        TextView name;
        TextView list_Item;
        public static ImageView profile_pic, list_icon;
        View getview;

        public MyHolderView(View view, int Viewtype) {
            super(view);
            getview = view;
            view.setClickable(true);

             if (Viewtype == VIEW_TYPE_HEADER) {
                header_viewprofile = (LinearLayout) view
                        .findViewById(R.id.headerText);
                name = (TextView) view
                        .findViewById(R.id.tv_header_profile_username);
                profile_pic = (ImageView) view
                        .findViewById(R.id.iv_header_profile_pic);
                profile_pic.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View click) {
                        if (listener != null) {
                            listener.onItemClick(click, getPosition());
                        }


                    }
                });

                Holderid = 0;
            }
            else if (Viewtype == VIEW_TYPE_ITEM) {
                list_Item = (TextView) view
                        .findViewById(R.id.tvDrawer_title);
                list_icon = (ImageView) view
                        .findViewById(R.id.ivdrawer_icon);
                list_Item.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View click) {
                        if (listener != null) {
                            listener.onItemClick(click, getPosition());
                        }


                    }
                });


                 Holderid = 1;
            }  else if (Viewtype == VIEW_TYPE_FOOTER) {

                Holderid = 2;
            }

        }
    }

    @Override
    public int getItemCount() {
        // TODO Auto-generated method stub
        return listItem.length + 1;
    }



    @Override
    public NavigationDrawerAdapter.MyHolderView onCreateViewHolder(
            ViewGroup root_parent, int position) {

        if (position == VIEW_TYPE_ITEM) {

            View v = LayoutInflater.from(root_parent.getContext()).inflate(
                    R.layout.nav_drawer_row, root_parent, false);
             v.setTag(position);
            MyHolderView holdview = new MyHolderView(v, position);

            return holdview;
        }

        else if (position == VIEW_TYPE_HEADER) {
            View v = LayoutInflater.from(root_parent.getContext()).inflate(
                    R.layout.drawer_header, root_parent, false);
            v.setTag(position);
            MyHolderView viewhold = new MyHolderView(v, position);

            return viewhold;
        }
        else if (position == VIEW_TYPE_FOOTER) {
            View v = LayoutInflater.from(root_parent.getContext()).inflate(
                    R.layout.nav_frawer_other, root_parent,
                    false);
            v.setTag(position);
            MyHolderView viewhold = new MyHolderView(v, position);
            return viewhold;
        }
        return null;
    }

    @Override
    public int getItemViewType(int position) {

        if (isPositionHeader(position))

            return VIEW_TYPE_HEADER;

        if (isPositionItem(position))

            return VIEW_TYPE_ITEM;

        if (isPositionItemtwo(position))

            return VIEW_TYPE_ITEM;

        if (isPositionItemthird(position))

            return VIEW_TYPE_ITEM;

        if (isPositionItemfourth(position))

            return VIEW_TYPE_ITEM;

        if (isPositionItemfifth(position))

            return VIEW_TYPE_ITEM;

        if (isPositionItemsix(position))

            return VIEW_TYPE_ITEM;

        if (isPositionItemseventh(position))

            return VIEW_TYPE_ITEM;

        if (isPositionItemeight(position))

            return VIEW_TYPE_ITEM;
        if (isPositionItemnine(position))

            return VIEW_TYPE_ITEM;
        if (isPositionItemten(position))

            return VIEW_TYPE_FOOTER;
        if (isPositionItemeleven(position))

            return VIEW_TYPE_ITEM;
        if (isPositionItemtwelve(position))

            return VIEW_TYPE_ITEM;

        if (isPositionItemfooter(position))

            return VIEW_TYPE_ITEM;

        else
            return VIEW_TYPE_ITEM;

    }

    private boolean isPositionHeader(int position) {
        return position == 0;
    }
    private boolean isPositionItem(int position) {
        return position == 1;
    }
    private boolean isPositionItemtwo(int position) {
        return position == 2;
    }
    private boolean isPositionItemthird(int position) {
        return position == 3;
    }
    private boolean isPositionItemfourth(int position) {
        return position == 4;
    }
    private boolean isPositionItemfifth(int position) {
        return position == 5;
    }
    private boolean isPositionItemsix(int position) {
        return position == 6;
    }
    private boolean isPositionItemseventh(int position) {
        return position == 7;
    }
    private boolean isPositionItemeight(int position) {
        return position == 8;
    }
    private boolean isPositionItemnine(int position) {
        return position == 9;
    }
    private boolean isPositionItemten(int position) {
        return position == 10;
    }
    private boolean isPositionItemeleven(int position) {
        return position == 11;
    }
    private boolean isPositionItemtwelve(int position) {
        return position == 12;
    }
    private boolean isPositionItemthirteen(int position) {
        return position == 13;
    }
    private boolean isPositionItemfourteen(int position) {
        return position == 14;
    }
    private boolean isPositionItemfooter(int position) {
        return position == 15;
    }


    @Override
    public void onBindViewHolder(MyHolderView holder, int position) {

        this.myholder = holder;
        if (MyHolderView.Holderid == 0) {
            holder.profile_pic.setImageResource(profile);
            holder.name.setText(profile_name);
        }
        if (MyHolderView.Holderid == 1) {
            holder.list_Item.setText(listItem[position - 1]);
            holder.list_icon.setImageResource(listIcon[position - 1]);

        }
        if (MyHolderView.Holderid == 2) {

        }


    }

}
