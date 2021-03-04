package gppTransform

import gppBuilder.GPPbuilder
import gppClusterBuilder.CGPPbuilder

import javax.swing.JFileChooser
import javax.swing.filechooser.FileNameExtensionFilter

class GppTransformer {

  static void gppTransform(){
    JFileChooser fileChooser = new JFileChooser()
    fileChooser.setLocation(400,400)
    fileChooser.setSize(1000, 1000)
    fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("GPP Files", "gpp", "cgpp"))
    fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")))
    int result = fileChooser.showOpenDialog()
    if (result == JFileChooser.APPROVE_OPTION) {
      File selectedFile = fileChooser.getSelectedFile()
      String fileName = selectedFile.toString()
//      println "Transforming $fileName to"
      int fnSize = fileName.size()
      String fileRoot
      if (fileName.endsWith("cgpp")) { // *.cgpp file
        fileRoot = fileName.substring(0, fnSize-5)
//        println " $fileRoot (HostLoader, HostProcess, NodeLoader, NodeProcess).groovy"
        def cgpp = new CGPPbuilder()
        cgpp.runClusterBuilder(fileRoot)
      }
      else{ // simple *.gpp file
        fileRoot = fileName.substring(0, fnSize-4)
//        println " ${fileRoot}.groovy"
        def gpp = new GPPbuilder()
        gpp.runBuilder(fileRoot )
      }
    }

  }

  static void main(String[] args) {
    GppTransformer gppT = new GppTransformer()
    gppT.gppTransform()
  }
}
