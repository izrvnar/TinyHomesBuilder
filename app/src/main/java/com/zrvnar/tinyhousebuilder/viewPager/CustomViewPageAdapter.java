package com.zrvnar.tinyhousebuilder.viewPager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.zrvnar.tinyhousebuilder.R;

public class CustomViewPageAdapter extends FragmentStateAdapter {
    public CustomViewPageAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0: return BuildDetailFragment.newInstance("Finding a Lot",
                    "To begin your Tiny house build the first thing youll need is a lot",
                    R.drawable.lot_image,
                    "5195512872",
                    "izdev@gmail.com",
                    "https://www.google.com/search?q=realesate+agents+near+me&oq=realesate+agents+near+me&aqs=chrome..69i57j0i13i457i512j0i402l2j0i13i512l6.7252j0j7&sourceid=chrome&ie=UTF-8",
                    "Real Estate Agent"
                    );

            case 1: return BuildDetailFragment.newInstance("Excavation",
                    "Most tiny houses are on a concrete slab but still require some sort of digging!",
                    R.drawable.excavator,
                    "5195512872",
                    "izdev@gmail.com",
                    "https://www.google.com/search?q=realesate+agents+near+me&oq=realesate+agents+near+me&aqs=chrome..69i57j0i13i457i512j0i402l2j0i13i512l6.7252j0j7&sourceid=chrome&ie=UTF-8",
                    "Excavator"
                    );

            case 2: return BuildDetailFragment.newInstance("Exterior",
                    "Once there is a foundation you can begin to frame the house and add a roof",
                    R.drawable.lot_image,
                    "5195512872",
                    "izdev@gmail.com",
                    "https://www.google.com/search?q=framers+contractors+near+me&sxsrf=ALiCzsZ0i0ykoKdKVeHSFf-KPXDXt_LlPw%3A1669677214184&ei=nkCFY4_nCsqmqtsPktKKiAs&oq=framers++contranear+me&gs_lcp=Cgxnd3Mtd2l6LXNlcnAQAxgAMgYIABAHEB4yBQgAEIYDMgUIABCGAzIFCAAQhgMyBQgAEIYDOgoIABBHENYEELADOggIABCSAxCwAzoKCAAQyQMQsAMQQzoHCAAQsAMQQzoECAAQQzoICAAQBxAeEAo6BwgAEIAEEA06CAgAEAgQBxAeOggIABAFEB4QDToICAAQCBAeEA1KBAhBGABKBAhGGABQ6wtYlxVgmxxoAXABeACAAWyIAYEFkgEDNS4ymAEAoAEByAEKwAEB&sclient=gws-wiz-serp",
                    "Framer"
                    );

            case 3: return BuildDetailFragment.newInstance("Plumbing",
                    "You will also need to find a pluming solution",
                    R.drawable.plumber_image,
                    "5195512872",
                    "izdev@gmail.com",
                    "https://www.google.com/search?q=plumbers+near+me&sxsrf=ALiCzsYjXZz3Gp7SwMi7z0GtSgy3vljqvQ%3A1669677223426&ei=p0CFY-TFGd67qtsPsNOIgA4&oq=plu+near+me&gs_lcp=Cgxnd3Mtd2l6LXNlcnAQAxgAMgYIABAHEB4yBggAEAcQHjIGCAAQBxAeMgYIABAHEB4yBggAEAcQHjIGCAAQBxAeMgYIABAHEB4yBggAEAcQHjIGCAAQBxAeMgYIABAHEB5KBAhBGABKBAhGGABQAFjUAmDdDmgAcAF4AIABW4gBjAKSAQEzmAEAoAEBwAEB&sclient=gws-wiz-serp",
                    "Plumber");

            case 4: return BuildDetailFragment.newInstance("Electrical",
                    "You will also need to find an electrical solution by possibly using solar panels",
                    R.drawable.electrician_img,
                    "5195512872",
                    "izdev@gmail.com",
                    "Cgxnd3Mtd2l6LXNlcnAQAxgAMgYIABAHEB4yBggAEAcQHjIGCAAQBxAeMgYIABAHEB4yBggAEAcQHjIGCAAQBxAeMgYIABAHEB4yBggAEAcQHjIGCAAQBxAeMgYIABAHEB46CggAEEcQ1gQQsAM6CAgAEJIDELADOhIILhDHARDRAxDIAxCwAxBDGAFKBAhBGABKBAhGGABQnO4BWIfwAWCi9gFoBnABeACAAWqIAZoCkgEDMi4xmAEAoAEByAEMwAEB2gEECAEYCA",
                    "Electrician");

            case 5: return BuildDetailFragment.newInstance("Interior",
                    "Things like HVAC, Drywall,",
                    R.drawable.lot_image,
                    "5195512872",
                    "izdev@gmail.com",
                    "https://www.google.com/search?q=drywall+contractors+near+me&sxsrf=ALiCzsbfMNcZFRFahpkZrc5UAf3rqc1ztQ%3A1669677281902&ei=4UCFY9TZNtGmqtsPgeyHgA0&oq=drywnear+me&gs_lcp=Cgxnd3Mtd2l6LXNlcnAQARgAMgYIABAHEB4yBggAEAcQHjIGCAAQBxAeMgYIABAHEB4yBggAEAcQHjIGCAAQBxAeMgYIABAHEB4yBggAEAcQHjIGCAAQBxAeMgYIABAHEB5KBAhBGABKBAhGGABQAFjxBmC-EWgAcAF4AIABaYgB4QKSAQMzLjGYAQCgAQHAAQE&sclient=gws-wiz-serp",
                    "Drywaller"
                    );

            default: return BuildDetailFragment.newInstance("404 Fragment not found", "You went to far", R.drawable.error_logo, "Error", "Error", "Error", "Error");
        }
    }

    @Override
    public int getItemCount() {
        return 6;
    }
}
