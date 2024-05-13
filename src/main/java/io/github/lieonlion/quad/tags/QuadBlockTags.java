package io.github.lieonlion.quad.tags;

import io.github.lieonlion.quad.Quad;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class QuadBlockTags {
    public static final TagKey<Block> CATS_ON_BLOCKS_SIT = createTag("cats_on_blocks/sit");
    public static final TagKey<Block> CATS_ON_BLOCKS_LIE = createTag("cats_on_blocks/lie");

    public static final TagKey<Block> WHEN_STEPPED_ON_BURNS = createTag("when_stepped_on/burns");
    public static final TagKey<Block> WHEN_STEPPED_ON_SLOWS = createTag("when_stepped_on/slows");
    public static final TagKey<Block> WHEN_STEPPED_ON_STICKS = createTag("when_stepped_on/sticks");

    public static final TagKey<Block> NETHER_PORTAL_FRAME = createTag("nether_portal_frame");

    private static TagKey<Block> createTag(String id) {
        return TagKey.create(Registries.BLOCK, Quad.asId(id));
    }
}