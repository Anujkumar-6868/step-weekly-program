// File: ArtGallery.java
class Art {
    public void display() { System.out.println("General artwork."); }
}
class Painting extends Art {
    public void brushTechnique() { System.out.println("Brush technique: Oil on canvas."); }
}
class Sculpture extends Art {
    public void material() { System.out.println("Material: Marble."); }
}

public class ArtGallery {
    public static void main(String[] args) {
        Art art = new Painting();  // Upcast
        art.display();
        
        // Downcasting
        if(art instanceof Painting) {
            Painting p = (Painting) art;
            p.brushTechnique();
        }
    }
}

