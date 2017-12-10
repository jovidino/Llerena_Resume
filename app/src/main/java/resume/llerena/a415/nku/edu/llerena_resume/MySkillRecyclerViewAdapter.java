package resume.llerena.a415.nku.edu.llerena_resume;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import resume.llerena.a415.nku.edu.llerena_resume.skillsListFragment.OnListFragmentInteractionListener;
import resume.llerena.a415.nku.edu.llerena_resume.Skills;

import java.util.List;

import static android.R.attr.data;

/**
 * {@link RecyclerView.Adapter} that can display a {@link //DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */

public class MySkillRecyclerViewAdapter extends RecyclerView.Adapter<MySkillRecyclerViewAdapter.ViewHolder> {

    //private final List<DummyItem> mValues;
    private List<Skills> skills;
    //private final OnListFragmentInteractionListener mListener;

    public MySkillRecyclerViewAdapter(List<Skills> skills) {
        //mValues = items;
        this.skills = skills;
        //mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_skills, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        //holder.mItem = skills.get(position);
        //holder.mIdView.setText(mValues.get(position).id);
        //holder.mContentView.setText(mValues.get(position).content);

        holder.mView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        //       if (null != mListener) {
        // Notify the active callbacks interface (the activity, if the
        // fragment is attached to one) that an item has been selected.
        //           mListener.onListFragmentInteraction(holder.mItem);
        //       }
           }
        });

        Skills vh = skills.get(position);
        holder.skill.setText(vh.skill);
    }

    @Override
    public int getItemCount() {
        return skills.size();
        //return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        //public final TextView mIdView;
        //public final TextView mContentView;
        //public DummyItem mItem;
        protected TextView skill;

        public ViewHolder(View view) {
            super(view);
            skill = (TextView)view.findViewById(R.id.skill);
            mView = view;
            //mIdView = (TextView) view.findViewById(R.id.id);
            //mContentView = (TextView) view.findViewById(R.id.id);
        }

        // @Override
        //public String toString() {
        //  return super.toString() + " '" + mContentView.getText() + "'";
        //}
    }
}
