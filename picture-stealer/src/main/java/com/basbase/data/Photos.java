package com.basbase.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Viktor Basanets
 * @Project: picture-stealer
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Photos {
    private List<PictureInfo> photos;
}
