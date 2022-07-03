package com.chyzman.ctft.classes;

import blue.endless.jankson.annotation.Nullable;
import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

import java.util.Arrays;
import java.util.List;

public class CustomBlockItem extends BlockItem {
    public boolean isfoil;
    public String type;
    public String texturetype;
    List<String> nines = Arrays.asList("9", "81", "729", "6,561", "59,049", "531,441", "4,782,969", "43,046,721", "387,420,489", "3,486,784,401", "31,381,059,609", "282,429,536,481", "2,541,865,828,329", "22,876,792,454,961", "205,891,132,094,649", "1,853,020,188,851,841", "16,677,181,699,666,569", "150,094,635,296,999,121", "1,350,851,717,672,992,089", "12,157,665,459,056,928,801", "109,418,989,131,512,359,209", "984,770,902,183,611,232,881", "8,862,938,119,652,501,095,929", "79,766,443,076,872,509,863,361", "717,897,987,691,852,588,770,249", "6,461,081,889,226,673,298,932,241", "58,149,737,003,040,059,690,390,169", "523,347,633,027,360,537,213,511,521", "4,710,128,697,246,244,834,921,603,689", "42,391,158,275,216,203,514,294,433,201", "381,520,424,476,945,831,628,649,898,809", "3,433,683,820,292,512,484,657,849,089,281", "30,903,154,382,632,612,361,920,641,803,529", "278,128,389,443,693,511,257,285,776,231,761", "2,503,155,504,993,241,601,315,571,986,085,849", "22,528,399,544,939,174,411,840,147,874,772,641", "202,755,595,904,452,569,706,561,330,872,953,769", "1,824,800,363,140,073,127,359,051,977,856,583,921", "16,423,203,268,260,658,146,231,467,800,709,255,289", "147,808,829,414,345,923,316,083,210,206,383,297,601", "1,330,279,464,729,113,309,844,748,891,857,449,678,409", "11,972,515,182,562,019,788,602,740,026,717,047,105,681", "107,752,636,643,058,178,097,424,660,240,453,423,951,129", "969,773,729,787,523,602,876,821,942,164,080,815,560,161", "8,727,963,568,087,712,425,891,397,479,476,727,340,041,449", "78,551,672,112,789,411,833,022,577,315,290,546,060,373,041", "706,965,049,015,104,706,497,203,195,837,614,914,543,357,369", "6,362,685,441,135,942,358,474,828,762,538,534,230,890,216,321", "57,264,168,970,223,481,226,273,458,862,846,808,078,011,946,889", "515,377,520,732,011,331,036,461,129,765,621,272,702,107,522,001", "4,638,397,686,588,101,979,328,150,167,890,591,454,318,967,698,009", "41,745,579,179,292,917,813,953,351,511,015,323,088,870,709,282,081", "375,710,212,613,636,260,325,580,163,599,137,907,799,836,383,538,729", "3,381,391,913,522,726,342,930,221,472,392,241,170,198,527,451,848,561", "30,432,527,221,704,537,086,371,993,251,530,170,531,786,747,066,637,049", "273,892,744,995,340,833,777,347,939,263,771,534,786,080,723,599,733,441", "2,465,034,704,958,067,503,996,131,453,373,943,813,074,726,512,397,600,969", "22,185,312,344,622,607,535,965,183,080,365,494,317,672,538,611,578,408,721", "199,667,811,101,603,467,823,686,647,723,289,448,859,052,847,504,205,678,489", "1,797,010,299,914,431,210,413,179,829,509,605,039,731,475,627,537,851,106,401", "16,173,092,699,229,880,893,718,618,465,586,445,357,583,280,647,840,659,957,609", "145,557,834,293,068,928,043,467,566,190,278,008,218,249,525,830,565,939,618,481", "1,310,020,508,637,620,352,391,208,095,712,502,073,964,245,732,475,093,456,566,329", "11,790,184,577,738,583,171,520,872,861,412,518,665,678,211,592,275,841,109,096,961", "106,111,661,199,647,248,543,687,855,752,712,667,991,103,904,330,482,569,981,872,649");

    public CustomBlockItem(Block block, boolean isFoil, String Type, String textureType, Settings settings) {
        super(block, settings);
        isfoil = isFoil;
        type = Type;
        texturetype = textureType;
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return isfoil || super.hasGlint(stack);
    }

    @Override
    public Text getName() {
        var baseitemname = (Registry.ITEM.getId(this.asItem())).getPath();
        return (Text.translatable("ctft.item." + this.type + "_prefix")
                .append(Text.translatable(this.texturetype + ".minecraft." + baseitemname
                        .substring(0, baseitemname
                                .lastIndexOf('_' + this.type))))
                .append(Text.translatable("ctft.item." + this.type + "_suffix")));
    }

    @Override
    public Text getName(ItemStack stack) {
        return this.getName();
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (type.equals("block")) {
            var baseitemname = (Registry.ITEM.getId(this.asItem())).getPath();
            tooltip.add(Text.literal("9 x ")
                    .append(Text.translatable(this.texturetype + ".minecraft." + baseitemname
                            .substring(0, baseitemname
                                    .lastIndexOf('_' + this.type)))).formatted(Formatting.GRAY));
        }
        if (type.startsWith("compressed")) {
            var baseitemname = (Registry.ITEM.getId(this.asItem())).getPath();
            tooltip.add(Text.literal(nines.get(Integer.parseInt(type.substring(10))) + " x ")
                    .append(Text.translatable(this.texturetype + ".minecraft." + baseitemname
                            .substring(0, baseitemname
                                    .lastIndexOf('_' + this.type)))).formatted(Formatting.GRAY));
        }
        super.appendTooltip(stack, world, tooltip, context);
    }
}
