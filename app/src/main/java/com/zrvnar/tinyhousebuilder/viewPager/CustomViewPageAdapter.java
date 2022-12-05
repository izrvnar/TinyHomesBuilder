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
                    "To begin your Tiny house build the first thing you'll need is a lot. The benfit of a tiny house is that they can built almost anywhere! A popular method is to place the home on a trailer frame which makes the house mobile.",
                    R.drawable.lot_image,
                    "5195512872",
                    "izdev@gmail.com",
                    "https://www.google.com/search?q=realesate+agents+near+me&oq=realesate+agents+near+me&aqs=chrome..69i57j0i13i457i512j0i402l2j0i13i512l6.7252j0j7&sourceid=chrome&ie=UTF-8",
                    "Real Estate Agent"
                    );

            case 1: return BuildDetailFragment.newInstance("Excavation",
                    "If you decide to not place the house on wheels, You will need some sort of foundation. The most common is a concrete slab. This is a very simple process and can be done by a professional or yourself. If you are going to do it yourself, make sure you have the proper equipment and knowledge to do so.",
                    R.drawable.excavator,
                    "5195512872",
                    "izdev@gmail.com",
                    "https://www.google.com/search?q=realesate+agents+near+me&oq=realesate+agents+near+me&aqs=chrome..69i57j0i13i457i512j0i402l2j0i13i512l6.7252j0j7&sourceid=chrome&ie=UTF-8",
                    "Excavator"
                    );

            case 2: return BuildDetailFragment.newInstance("Exterior",
                    "The exterior of the house is the first thing people will see. It is important to make sure that the exterior is well insulated and weather proof. The most common exterior is metal siding. This is a very durable and easy to maintain material. The most common type of metal siding is steel. Steel is very durable and can be painted to match any color.",
                    R.drawable.tiny_exterior,
                    "5195512872",
                    "izdev@gmail.com",
                    "https://www.google.com/search?q=framers+contractors+near+me&sxsrf=ALiCzsZ0i0ykoKdKVeHSFf-KPXDXt_LlPw%3A1669677214184&ei=nkCFY4_nCsqmqtsPktKKiAs&oq=framers++contranear+me&gs_lcp=Cgxnd3Mtd2l6LXNlcnAQAxgAMgYIABAHEB4yBQgAEIYDMgUIABCGAzIFCAAQhgMyBQgAEIYDOgoIABBHENYEELADOggIABCSAxCwAzoKCAAQyQMQsAMQQzoHCAAQsAMQQzoECAAQQzoICAAQBxAeEAo6BwgAEIAEEA06CAgAEAgQBxAeOggIABAFEB4QDToICAAQCBAeEA1KBAhBGABKBAhGGABQ6wtYlxVgmxxoAXABeACAAWyIAYEFkgEDNS4ymAEAoAEByAEKwAEB&sclient=gws-wiz-serp",
                    "Framer"
                    );

            case 3: return BuildDetailFragment.newInstance("Plumbing",
                    "If you really want to make your tiny house stand out, you can add a bathroom. The most common type of bathroom is a composting toilet. This is a very simple and easy to maintain toilet. The only thing you need to do is empty the composting toilet every few months. However if you are able to connect to a sewer system, you can install a regular toilet.",
                    R.drawable.plumber_image,
                    "5195512872",
                    "izdev@gmail.com",
                    "https://www.google.com/search?q=plumbers+near+me&sxsrf=ALiCzsYjXZz3Gp7SwMi7z0GtSgy3vljqvQ%3A1669677223426&ei=p0CFY-TFGd67qtsPsNOIgA4&oq=plu+near+me&gs_lcp=Cgxnd3Mtd2l6LXNlcnAQAxgAMgYIABAHEB4yBggAEAcQHjIGCAAQBxAeMgYIABAHEB4yBggAEAcQHjIGCAAQBxAeMgYIABAHEB4yBggAEAcQHjIGCAAQBxAeMgYIABAHEB5KBAhBGABKBAhGGABQAFjUAmDdDmgAcAF4AIABW4gBjAKSAQEzmAEAoAEBwAEB&sclient=gws-wiz-serp",
                    "Plumber");

            case 4: return BuildDetailFragment.newInstance("Electrical",
                    "One of the advantages of a tiny house is that you are able to run solar panels. In the long term they are very cost effective and environmentally friendly. However if you are not able to run solar panels, you can run a regular electrical system. The most common type of electrical system is a 100 amp service. This is a very simple and easy to install system.",
                    R.drawable.solar_panel_img,
                    "5195512872",
                    "izdev@gmail.com",
                    "Cgxnd3Mtd2l6LXNlcnAQAxgAMgYIABAHEB4yBggAEAcQHjIGCAAQBxAeMgYIABAHEB4yBggAEAcQHjIGCAAQBxAeMgYIABAHEB4yBggAEAcQHjIGCAAQBxAeMgYIABAHEB46CggAEEcQ1gQQsAM6CAgAEJIDELADOhIILhDHARDRAxDIAxCwAxBDGAFKBAhBGABKBAhGGABQnO4BWIfwAWCi9gFoBnABeACAAWqIAZoCkgEDMi4xmAEAoAEByAEMwAEB2gEECAEYCA",
                    "Electrician");

            case 5: return BuildDetailFragment.newInstance("Interior",
                    "There are many different aspects of the interior of the house. The most important thing is to be conscious of the space. For heating and cooling a real fireplace can be a great option. For cooling ductless are very efficient and take up little space.  ",
                    R.drawable.tiny_interior,
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
