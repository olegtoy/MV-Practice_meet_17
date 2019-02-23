package com.practice.olegtojgildin.mvpractice_meet_17.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by olegtojgildin on 22/02/2019.
 */

public class ImageMapper {
    public static List<ImageModel> maptoImages(final List<Hit> imageHits) {
        final List<ImageModel> images = new ArrayList<>();
        for (int i = 0; i < imageHits.size(); i++) {
            images.add(maptoImage(i, imageHits.get(i)));
        }
        return images;
    }
    private static ImageModel maptoImage(final int position, final Hit hit) {

        ImageModel image=new ImageModel();
        image.setTitle(hit.getUser());
        image.setUrlImage(hit.getWebformatURL());
        return image;
    }
}
