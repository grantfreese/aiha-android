package com.larvalabs.svgandroid.test;

import com.larvalabs.svgandroid.SVG;
import com.larvalabs.svgandroid.SVGParser;

import android.content.res.AssetManager;
import android.graphics.Point;
import android.test.AndroidTestCase;

import java.util.ArrayList;

/**
 * Makes use of test svg images from http://www.w3.org/Graphics/SVG/Test/20061213/archives/W3C_SVG_11_BasicTestSuite.tar.gz to
 * verify parser is functioning properly.
 */
public class SVGParserTest extends AndroidTestCase {

    public void testShapes() throws Exception {
        AssetManager assets = getContext().getAssets();
        SVG svg = SVGParser.getSVGFromAsset(assets, "svg/shapes.svg");
        SVGTestPair pair = new SVGTestPair(assets.open("png/shapes.png"), svg, "shapes");

        // Verify that a hand picked set of points is the same
        ArrayList<Point> comparePts = new ArrayList<Point>();
        comparePts.add(new Point(312, 350));
        comparePts.add(new Point(454, 420));
        comparePts.add(new Point(392, 471));
        assertTrue(pair.comparePoints(comparePts));
        assertTrue(pair.comparePointsOnHorizontalLine(95, 70));

        // Verify that the two images don't differ too much overall, sanity check
        float diff = pair.fractionalDifference();
        System.out.println("Fractional difference between samples: " + diff);
        assertTrue(diff < 0.1);
    }

    public void testStrokes() throws Exception {
        AssetManager assets = getContext().getAssets();
        SVG svg = SVGParser.getSVGFromAsset(assets, "svg/strokes.svg");
        SVGTestPair pair = new SVGTestPair(assets.open("png/strokes.png"), svg, "strokes");

        assertTrue(pair.comparePointsOnHorizontalLine(113, 50));
        assertTrue(pair.comparePointsOnHorizontalLine(229, 50));
        assertTrue(pair.comparePointsOnHorizontalLine(357, 50));

        // Verify that the two images don't differ too much overall
        float diff = pair.fractionalDifference();
        System.out.println("Fractional difference between samples: " + diff);
        assertTrue(diff < 0.1);
    }

    public void testTransformations() throws Exception {
        AssetManager assets = getContext().getAssets();
        SVG svg = SVGParser.getSVGFromAsset(assets, "svg/transformations.svg");
        SVGTestPair pair = new SVGTestPair(assets.open("png/transformations.png"), svg, "transformations");

        assertTrue(pair.comparePointsOnHorizontalLine(110, 50));
        assertTrue(pair.comparePointsOnHorizontalLine(153, 50));
        assertTrue(pair.comparePointsOnHorizontalLine(358, 50));

        // Verify that the two images don't differ too much overall
        float diff = pair.fractionalDifference();
        System.out.println("Fractional difference between samples: " + diff);
        assertTrue(diff < 0.1);
    }

    public void testGradients() throws Exception {
        AssetManager assets = getContext().getAssets();
        SVG svg = SVGParser.getSVGFromAsset(assets, "svg/gradients.svg");
        SVGTestPair pair = new SVGTestPair(assets.open("png/gradients.png"), svg, "gradients");

        ArrayList<Point> comparePts = new ArrayList<Point>();
        comparePts.add(new Point(209, 83));
        comparePts.add(new Point(169, 192));
        comparePts.add(new Point(253, 175));
        comparePts.add(new Point(344, 320));
        assertTrue(pair.comparePoints(comparePts));

        assertTrue(pair.comparePointsOnHorizontalLine(100, 50));
        assertTrue(pair.comparePointsOnHorizontalLine(400, 40));

        // Verify that the two images don't differ too much overall
        float diff = pair.fractionalDifference();
        System.out.println("Fractional difference between samples: " + diff);
        assertTrue(diff < 0.1);
    }

    /**
     * This test file was provided by the svg-android-2 author, however it's
     * unclear why exactly since it appears to fail even with that developer's
     * svg-android modifications. Provided here for completeness, though looking
     * at the SVG I'm not really sure that this would ever be something this
     * library would need to support.
     */
    public void testInkscape() throws Exception {
        AssetManager assets = getContext().getAssets();
        SVG svg = SVGParser.getSVGFromAsset(assets, "svg/inkscape.svg");
        SVGTestPair pair = new SVGTestPair(assets.open("png/inkscape.png"), svg, "inkscape");

        assertTrue(pair.comparePointsOnHorizontalLine(35, 50));
        assertTrue(pair.comparePointsOnHorizontalLine(62, 50));
        assertTrue(pair.comparePointsOnHorizontalLine(111, 50));
        assertTrue(pair.comparePointsOnHorizontalLine(142, 50));

        float diff = pair.fractionalDifference();
        System.out.println("Fractional difference between samples: " + diff);
        assertTrue(diff < 0.1);
    }
}
