
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package servicios;

import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;

/**
 * This class was generated by Apache CXF 3.2.6
 * 2018-11-13T18:03:44.274-03:00
 * Generated source version: 3.2.6
 *
 */

@javax.jws.WebService(
                      serviceName = "PublicadorService",
                      portName = "PublicadorPort",
                      targetNamespace = "http://servicios/",
                      wsdlLocation = "http://localhost:10135/publicador?wsdl",
                      endpointInterface = "servicios.Publicador")

public class PublicadorPortImpl implements Publicador {

    private static final Logger LOG = Logger.getLogger(PublicadorPortImpl.class.getName());

    /* (non-Javadoc)
     * @see servicios.Publicador#prueba(java.lang.String arg0)*
     */
    public java.lang.String prueba(java.lang.String arg0) {
        LOG.info("Executing operation prueba");
        System.out.println(arg0);
        try {
            java.lang.String _return = "_return-249301287";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see servicios.Publicador#getDtVideosPropietario(java.lang.String arg0)*
     */
    public servicios.DtPaquete getDtVideosPropietario(java.lang.String arg0) {
        LOG.info("Executing operation getDtVideosPropietario");
        System.out.println(arg0);
        try {
            servicios.DtPaquete _return = new servicios.DtPaquete();
            servicios.DtUniversal _returnContenido = null;
            _return.setContenido(_returnContenido);
            java.util.List<java.lang.String> _returnListaAux = new java.util.ArrayList<java.lang.String>();
            java.lang.String _returnListaAuxVal1 = "_returnListaAuxVal-439975979";
            _returnListaAux.add(_returnListaAuxVal1);
            _return.getListaAux().addAll(_returnListaAux);
            java.util.List<servicios.DtUniversal> _returnListaDt = new java.util.ArrayList<servicios.DtUniversal>();
            servicios.DtUniversal _returnListaDtVal1 = null;
            _returnListaDt.add(_returnListaDtVal1);
            _return.getListaDt().addAll(_returnListaDt);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see servicios.Publicador#consultaDeCategoria(java.lang.String arg0)*
     */
    public servicios.DtPaquete consultaDeCategoria(java.lang.String arg0) {
        LOG.info("Executing operation consultaDeCategoria");
        System.out.println(arg0);
        try {
            servicios.DtPaquete _return = new servicios.DtPaquete();
            servicios.DtUniversal _returnContenido = null;
            _return.setContenido(_returnContenido);
            java.util.List<java.lang.String> _returnListaAux = new java.util.ArrayList<java.lang.String>();
            java.lang.String _returnListaAuxVal1 = "_returnListaAuxVal-563205426";
            _returnListaAux.add(_returnListaAuxVal1);
            _return.getListaAux().addAll(_returnListaAux);
            java.util.List<servicios.DtUniversal> _returnListaDt = new java.util.ArrayList<servicios.DtUniversal>();
            servicios.DtUniversal _returnListaDtVal1 = null;
            _returnListaDt.add(_returnListaDtVal1);
            _return.getListaDt().addAll(_returnListaDt);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see servicios.Publicador#checkLogin(java.lang.String arg0, java.lang.String arg1)*
     */
    public boolean checkLogin(java.lang.String arg0, java.lang.String arg1) {
        LOG.info("Executing operation checkLogin");
        System.out.println(arg0);
        System.out.println(arg1);
        try {
            boolean _return = false;
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see servicios.Publicador#getDtVideo(int arg0)*
     */
    public servicios.DtPaquete getDtVideo(int arg0) {
        LOG.info("Executing operation getDtVideo");
        System.out.println(arg0);
        try {
            servicios.DtPaquete _return = new servicios.DtPaquete();
            servicios.DtUniversal _returnContenido = null;
            _return.setContenido(_returnContenido);
            java.util.List<java.lang.String> _returnListaAux = new java.util.ArrayList<java.lang.String>();
            java.lang.String _returnListaAuxVal1 = "_returnListaAuxVal2124289412";
            _returnListaAux.add(_returnListaAuxVal1);
            _return.getListaAux().addAll(_returnListaAux);
            java.util.List<servicios.DtUniversal> _returnListaDt = new java.util.ArrayList<servicios.DtUniversal>();
            servicios.DtUniversal _returnListaDtVal1 = null;
            _returnListaDt.add(_returnListaDtVal1);
            _return.getListaDt().addAll(_returnListaDt);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see servicios.Publicador#getSeguidos(java.lang.String arg0)*
     */
    public servicios.DtPaquete getSeguidos(java.lang.String arg0) {
        LOG.info("Executing operation getSeguidos");
        System.out.println(arg0);
        try {
            servicios.DtPaquete _return = new servicios.DtPaquete();
            servicios.DtUniversal _returnContenido = null;
            _return.setContenido(_returnContenido);
            java.util.List<java.lang.String> _returnListaAux = new java.util.ArrayList<java.lang.String>();
            java.lang.String _returnListaAuxVal1 = "_returnListaAuxVal-1984297870";
            _returnListaAux.add(_returnListaAuxVal1);
            _return.getListaAux().addAll(_returnListaAux);
            java.util.List<servicios.DtUniversal> _returnListaDt = new java.util.ArrayList<servicios.DtUniversal>();
            servicios.DtUniversal _returnListaDtVal1 = null;
            _returnListaDt.add(_returnListaDtVal1);
            _return.getListaDt().addAll(_returnListaDt);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see servicios.Publicador#getDtListasParticularesPublicasUsuario(java.lang.String arg0)*
     */
    public servicios.DtPaquete getDtListasParticularesPublicasUsuario(java.lang.String arg0) {
        LOG.info("Executing operation getDtListasParticularesPublicasUsuario");
        System.out.println(arg0);
        try {
            servicios.DtPaquete _return = new servicios.DtPaquete();
            servicios.DtUniversal _returnContenido = null;
            _return.setContenido(_returnContenido);
            java.util.List<java.lang.String> _returnListaAux = new java.util.ArrayList<java.lang.String>();
            java.lang.String _returnListaAuxVal1 = "_returnListaAuxVal-1780440977";
            _returnListaAux.add(_returnListaAuxVal1);
            _return.getListaAux().addAll(_returnListaAux);
            java.util.List<servicios.DtUniversal> _returnListaDt = new java.util.ArrayList<servicios.DtUniversal>();
            servicios.DtUniversal _returnListaDtVal1 = null;
            _returnListaDt.add(_returnListaDtVal1);
            _return.getListaDt().addAll(_returnListaDt);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see servicios.Publicador#listarDtVideosDuenosLista(java.lang.String arg0, java.lang.String arg1, boolean arg2)*
     */
    public servicios.DtPaquete listarDtVideosDuenosLista(java.lang.String arg0, java.lang.String arg1, boolean arg2) {
        LOG.info("Executing operation listarDtVideosDuenosLista");
        System.out.println(arg0);
        System.out.println(arg1);
        System.out.println(arg2);
        try {
            servicios.DtPaquete _return = new servicios.DtPaquete();
            servicios.DtUniversal _returnContenido = null;
            _return.setContenido(_returnContenido);
            java.util.List<java.lang.String> _returnListaAux = new java.util.ArrayList<java.lang.String>();
            java.lang.String _returnListaAuxVal1 = "_returnListaAuxVal-289951954";
            _returnListaAux.add(_returnListaAuxVal1);
            _return.getListaAux().addAll(_returnListaAux);
            java.util.List<servicios.DtUniversal> _returnListaDt = new java.util.ArrayList<servicios.DtUniversal>();
            servicios.DtUniversal _returnListaDtVal1 = null;
            _returnListaDt.add(_returnListaDtVal1);
            _return.getListaDt().addAll(_returnListaDt);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see servicios.Publicador#modificarValoracion(boolean arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3)*
     */
    public void modificarValoracion(boolean arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3) {
        LOG.info("Executing operation modificarValoracion");
        System.out.println(arg0);
        System.out.println(arg1);
        System.out.println(arg2);
        System.out.println(arg3);
        try {
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see servicios.Publicador#listarNombresUsuarios()*
     */
    public servicios.DtPaquete listarNombresUsuarios() {
        LOG.info("Executing operation listarNombresUsuarios");
        try {
            servicios.DtPaquete _return = new servicios.DtPaquete();
            servicios.DtUniversal _returnContenido = null;
            _return.setContenido(_returnContenido);
            java.util.List<java.lang.String> _returnListaAux = new java.util.ArrayList<java.lang.String>();
            java.lang.String _returnListaAuxVal1 = "_returnListaAuxVal-721621309";
            _returnListaAux.add(_returnListaAuxVal1);
            _return.getListaAux().addAll(_returnListaAux);
            java.util.List<servicios.DtUniversal> _returnListaDt = new java.util.ArrayList<servicios.DtUniversal>();
            servicios.DtUniversal _returnListaDtVal1 = null;
            _returnListaDt.add(_returnListaDtVal1);
            _return.getListaDt().addAll(_returnListaDt);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see servicios.Publicador#getDtVideosPublicos(java.lang.String arg0)*
     */
    public servicios.DtPaquete getDtVideosPublicos(java.lang.String arg0) {
        LOG.info("Executing operation getDtVideosPublicos");
        System.out.println(arg0);
        try {
            servicios.DtPaquete _return = new servicios.DtPaquete();
            servicios.DtUniversal _returnContenido = null;
            _return.setContenido(_returnContenido);
            java.util.List<java.lang.String> _returnListaAux = new java.util.ArrayList<java.lang.String>();
            java.lang.String _returnListaAuxVal1 = "_returnListaAuxVal-409578268";
            _returnListaAux.add(_returnListaAuxVal1);
            _return.getListaAux().addAll(_returnListaAux);
            java.util.List<servicios.DtUniversal> _returnListaDt = new java.util.ArrayList<servicios.DtUniversal>();
            servicios.DtUniversal _returnListaDtVal1 = null;
            _returnListaDt.add(_returnListaDtVal1);
            _return.getListaDt().addAll(_returnListaDt);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see servicios.Publicador#altaListaParticular(java.lang.String arg0, java.lang.String arg1, boolean arg2)*
     */
    public void altaListaParticular(java.lang.String arg0, java.lang.String arg1, boolean arg2) throws DuplicateClassException_Exception   {
        LOG.info("Executing operation altaListaParticular");
        System.out.println(arg0);
        System.out.println(arg1);
        System.out.println(arg2);
        try {
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new DuplicateClassException_Exception("DuplicateClassException...");
    }

    /* (non-Javadoc)
     * @see servicios.Publicador#listarCategorias()*
     */
    public servicios.DtPaquete listarCategorias() {
        LOG.info("Executing operation listarCategorias");
        try {
            servicios.DtPaquete _return = new servicios.DtPaquete();
            servicios.DtUniversal _returnContenido = null;
            _return.setContenido(_returnContenido);
            java.util.List<java.lang.String> _returnListaAux = new java.util.ArrayList<java.lang.String>();
            java.lang.String _returnListaAuxVal1 = "_returnListaAuxVal-1604388849";
            _returnListaAux.add(_returnListaAuxVal1);
            _return.getListaAux().addAll(_returnListaAux);
            java.util.List<servicios.DtUniversal> _returnListaDt = new java.util.ArrayList<servicios.DtUniversal>();
            servicios.DtUniversal _returnListaDtVal1 = null;
            _returnListaDt.add(_returnListaDtVal1);
            _return.getListaDt().addAll(_returnListaDt);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see servicios.Publicador#getImagen(java.lang.String arg0)*
     */
    public byte[] getImagen(java.lang.String arg0) {
        LOG.info("Executing operation getImagen");
        System.out.println(arg0);
        try {
            byte[] _return = new byte[] {};
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see servicios.Publicador#yaCalificado(java.lang.String arg0, boolean arg1, java.lang.String arg2, java.lang.String arg3)*
     */
    public boolean yaCalificado(java.lang.String arg0, boolean arg1, java.lang.String arg2, java.lang.String arg3) {
        LOG.info("Executing operation yaCalificado");
        System.out.println(arg0);
        System.out.println(arg1);
        System.out.println(arg2);
        System.out.println(arg3);
        try {
            boolean _return = false;
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see servicios.Publicador#dejarSeguir(java.lang.String arg0, java.lang.String arg1)*
     */
    public void dejarSeguir(java.lang.String arg0, java.lang.String arg1) {
        LOG.info("Executing operation dejarSeguir");
        System.out.println(arg0);
        System.out.println(arg1);
        try {
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see servicios.Publicador#busquedaVideo(java.lang.String arg0, int arg1)*
     */
    public servicios.DtPaquete busquedaVideo(java.lang.String arg0, int arg1) {
        LOG.info("Executing operation busquedaVideo");
        System.out.println(arg0);
        System.out.println(arg1);
        try {
            servicios.DtPaquete _return = new servicios.DtPaquete();
            servicios.DtUniversal _returnContenido = null;
            _return.setContenido(_returnContenido);
            java.util.List<java.lang.String> _returnListaAux = new java.util.ArrayList<java.lang.String>();
            java.lang.String _returnListaAuxVal1 = "_returnListaAuxVal1243006938";
            _returnListaAux.add(_returnListaAuxVal1);
            _return.getListaAux().addAll(_returnListaAux);
            java.util.List<servicios.DtUniversal> _returnListaDt = new java.util.ArrayList<servicios.DtUniversal>();
            servicios.DtUniversal _returnListaDtVal1 = null;
            _returnListaDt.add(_returnListaDtVal1);
            _return.getListaDt().addAll(_returnListaDt);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see servicios.Publicador#cargarDatos()*
     */
    public void cargarDatos() {
        LOG.info("Executing operation cargarDatos");
        try {
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see servicios.Publicador#getSeguidores(java.lang.String arg0)*
     */
    public servicios.DtPaquete getSeguidores(java.lang.String arg0) {
        LOG.info("Executing operation getSeguidores");
        System.out.println(arg0);
        try {
            servicios.DtPaquete _return = new servicios.DtPaquete();
            servicios.DtUniversal _returnContenido = null;
            _return.setContenido(_returnContenido);
            java.util.List<java.lang.String> _returnListaAux = new java.util.ArrayList<java.lang.String>();
            java.lang.String _returnListaAuxVal1 = "_returnListaAuxVal-411816466";
            _returnListaAux.add(_returnListaAuxVal1);
            _return.getListaAux().addAll(_returnListaAux);
            java.util.List<servicios.DtUniversal> _returnListaDt = new java.util.ArrayList<servicios.DtUniversal>();
            servicios.DtUniversal _returnListaDtVal1 = null;
            _returnListaDt.add(_returnListaDtVal1);
            _return.getListaDt().addAll(_returnListaDt);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see servicios.Publicador#isSeguidor(java.lang.String arg0, java.lang.String arg1)*
     */
    public boolean isSeguidor(java.lang.String arg0, java.lang.String arg1) {
        LOG.info("Executing operation isSeguidor");
        System.out.println(arg0);
        System.out.println(arg1);
        try {
            boolean _return = false;
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see servicios.Publicador#quitarVideoLista(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, boolean arg4)*
     */
    public void quitarVideoLista(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, boolean arg4) {
        LOG.info("Executing operation quitarVideoLista");
        System.out.println(arg0);
        System.out.println(arg1);
        System.out.println(arg2);
        System.out.println(arg3);
        System.out.println(arg4);
        try {
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see servicios.Publicador#seguir(java.lang.String arg0, java.lang.String arg1)*
     */
    public void seguir(java.lang.String arg0, java.lang.String arg1) {
        LOG.info("Executing operation seguir");
        System.out.println(arg0);
        System.out.println(arg1);
        try {
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see servicios.Publicador#busquedaLista(java.lang.String arg0, int arg1)*
     */
    public servicios.DtPaquete busquedaLista(java.lang.String arg0, int arg1) {
        LOG.info("Executing operation busquedaLista");
        System.out.println(arg0);
        System.out.println(arg1);
        try {
            servicios.DtPaquete _return = new servicios.DtPaquete();
            servicios.DtUniversal _returnContenido = null;
            _return.setContenido(_returnContenido);
            java.util.List<java.lang.String> _returnListaAux = new java.util.ArrayList<java.lang.String>();
            java.lang.String _returnListaAuxVal1 = "_returnListaAuxVal1495553979";
            _returnListaAux.add(_returnListaAuxVal1);
            _return.getListaAux().addAll(_returnListaAux);
            java.util.List<servicios.DtUniversal> _returnListaDt = new java.util.ArrayList<servicios.DtUniversal>();
            servicios.DtUniversal _returnListaDtVal1 = null;
            _returnListaDt.add(_returnListaDtVal1);
            _return.getListaDt().addAll(_returnListaDt);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see servicios.Publicador#listarListasParticularUsuario(java.lang.String arg0)*
     */
    public servicios.DtPaquete listarListasParticularUsuario(java.lang.String arg0) {
        LOG.info("Executing operation listarListasParticularUsuario");
        System.out.println(arg0);
        try {
            servicios.DtPaquete _return = new servicios.DtPaquete();
            servicios.DtUniversal _returnContenido = null;
            _return.setContenido(_returnContenido);
            java.util.List<java.lang.String> _returnListaAux = new java.util.ArrayList<java.lang.String>();
            java.lang.String _returnListaAuxVal1 = "_returnListaAuxVal33380177";
            _returnListaAux.add(_returnListaAuxVal1);
            _return.getListaAux().addAll(_returnListaAux);
            java.util.List<servicios.DtUniversal> _returnListaDt = new java.util.ArrayList<servicios.DtUniversal>();
            servicios.DtUniversal _returnListaDtVal1 = null;
            _returnListaDt.add(_returnListaDtVal1);
            _return.getListaDt().addAll(_returnListaDt);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see servicios.Publicador#listarTodosLosVideos(java.lang.String arg0)*
     */
    public servicios.DtPaquete listarTodosLosVideos(java.lang.String arg0) {
        LOG.info("Executing operation listarTodosLosVideos");
        System.out.println(arg0);
        try {
            servicios.DtPaquete _return = new servicios.DtPaquete();
            servicios.DtUniversal _returnContenido = null;
            _return.setContenido(_returnContenido);
            java.util.List<java.lang.String> _returnListaAux = new java.util.ArrayList<java.lang.String>();
            java.lang.String _returnListaAuxVal1 = "_returnListaAuxVal-2098604060";
            _returnListaAux.add(_returnListaAuxVal1);
            _return.getListaAux().addAll(_returnListaAux);
            java.util.List<servicios.DtUniversal> _returnListaDt = new java.util.ArrayList<servicios.DtUniversal>();
            servicios.DtUniversal _returnListaDtVal1 = null;
            _returnListaDt.add(_returnListaDtVal1);
            _return.getListaDt().addAll(_returnListaDt);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see servicios.Publicador#busquedaGeneral(java.lang.String arg0, int arg1)*
     */
    public servicios.DtPaquete busquedaGeneral(java.lang.String arg0, int arg1) {
        LOG.info("Executing operation busquedaGeneral");
        System.out.println(arg0);
        System.out.println(arg1);
        try {
            servicios.DtPaquete _return = new servicios.DtPaquete();
            servicios.DtUniversal _returnContenido = null;
            _return.setContenido(_returnContenido);
            java.util.List<java.lang.String> _returnListaAux = new java.util.ArrayList<java.lang.String>();
            java.lang.String _returnListaAuxVal1 = "_returnListaAuxVal-163068460";
            _returnListaAux.add(_returnListaAuxVal1);
            _return.getListaAux().addAll(_returnListaAux);
            java.util.List<servicios.DtUniversal> _returnListaDt = new java.util.ArrayList<servicios.DtUniversal>();
            servicios.DtUniversal _returnListaDtVal1 = null;
            _returnListaDt.add(_returnListaDtVal1);
            _return.getListaDt().addAll(_returnListaDt);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see servicios.Publicador#getListaPublicoDtVideo()*
     */
    public servicios.DtPaquete getListaPublicoDtVideo() {
        LOG.info("Executing operation getListaPublicoDtVideo");
        try {
            servicios.DtPaquete _return = new servicios.DtPaquete();
            servicios.DtUniversal _returnContenido = null;
            _return.setContenido(_returnContenido);
            java.util.List<java.lang.String> _returnListaAux = new java.util.ArrayList<java.lang.String>();
            java.lang.String _returnListaAuxVal1 = "_returnListaAuxVal779707602";
            _returnListaAux.add(_returnListaAuxVal1);
            _return.getListaAux().addAll(_returnListaAux);
            java.util.List<servicios.DtUniversal> _returnListaDt = new java.util.ArrayList<servicios.DtUniversal>();
            servicios.DtUniversal _returnListaDtVal1 = null;
            _returnListaDt.add(_returnListaDtVal1);
            _return.getListaDt().addAll(_returnListaDt);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see servicios.Publicador#comentarVideo(java.lang.String arg0, javax.xml.datatype.XMLGregorianCalendar arg1, java.lang.String arg2, java.lang.String arg3, java.lang.String arg4)*
     */
    public void comentarVideo(java.lang.String arg0, javax.xml.datatype.XMLGregorianCalendar arg1, java.lang.String arg2, java.lang.String arg3, java.lang.String arg4) {
        LOG.info("Executing operation comentarVideo");
        System.out.println(arg0);
        System.out.println(arg1);
        System.out.println(arg2);
        System.out.println(arg3);
        System.out.println(arg4);
        try {
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see servicios.Publicador#valorarVideo(java.lang.String arg0, boolean arg1, java.lang.String arg2, java.lang.String arg3)*
     */
    public void valorarVideo(java.lang.String arg0, boolean arg1, java.lang.String arg2, java.lang.String arg3) {
        LOG.info("Executing operation valorarVideo");
        System.out.println(arg0);
        System.out.println(arg1);
        System.out.println(arg2);
        System.out.println(arg3);
        try {
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see servicios.Publicador#listarListasDefectoUsuario(java.lang.String arg0)*
     */
    public servicios.DtPaquete listarListasDefectoUsuario(java.lang.String arg0) {
        LOG.info("Executing operation listarListasDefectoUsuario");
        System.out.println(arg0);
        try {
            servicios.DtPaquete _return = new servicios.DtPaquete();
            servicios.DtUniversal _returnContenido = null;
            _return.setContenido(_returnContenido);
            java.util.List<java.lang.String> _returnListaAux = new java.util.ArrayList<java.lang.String>();
            java.lang.String _returnListaAuxVal1 = "_returnListaAuxVal-751293189";
            _returnListaAux.add(_returnListaAuxVal1);
            _return.getListaAux().addAll(_returnListaAux);
            java.util.List<servicios.DtUniversal> _returnListaDt = new java.util.ArrayList<servicios.DtUniversal>();
            servicios.DtUniversal _returnListaDtVal1 = null;
            _returnListaDt.add(_returnListaDtVal1);
            _return.getListaDt().addAll(_returnListaDt);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see servicios.Publicador#prueba2()*
     */
    public java.lang.String prueba2() {
        LOG.info("Executing operation prueba2");
        try {
            java.lang.String _return = "_return-955447203";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see servicios.Publicador#altaUsuario(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, javax.xml.datatype.XMLGregorianCalendar arg4, byte[] imagen, java.lang.String arg6, java.lang.String arg7, java.lang.String arg8, boolean arg9, java.lang.String arg10)*
     */
    public void altaUsuario(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, javax.xml.datatype.XMLGregorianCalendar arg4, byte[] imagen, java.lang.String arg6, java.lang.String arg7, java.lang.String arg8, boolean arg9, java.lang.String arg10) {
        LOG.info("Executing operation altaUsuario");
        System.out.println(arg0);
        System.out.println(arg1);
        System.out.println(arg2);
        System.out.println(arg3);
        System.out.println(arg4);
        System.out.println(imagen);
        System.out.println(arg6);
        System.out.println(arg7);
        System.out.println(arg8);
        System.out.println(arg9);
        System.out.println(arg10);
        try {
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see servicios.Publicador#modificarVideo(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.lang.String arg4, java.lang.String arg5, long arg6, boolean arg7, javax.xml.datatype.XMLGregorianCalendar arg8)*
     */
    public void modificarVideo(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.lang.String arg4, java.lang.String arg5, long arg6, boolean arg7, javax.xml.datatype.XMLGregorianCalendar arg8) {
        LOG.info("Executing operation modificarVideo");
        System.out.println(arg0);
        System.out.println(arg1);
        System.out.println(arg2);
        System.out.println(arg3);
        System.out.println(arg4);
        System.out.println(arg5);
        System.out.println(arg6);
        System.out.println(arg7);
        System.out.println(arg8);
        try {
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see servicios.Publicador#busquedaCanales(java.lang.String arg0, int arg1)*
     */
    public servicios.DtPaquete busquedaCanales(java.lang.String arg0, int arg1) {
        LOG.info("Executing operation busquedaCanales");
        System.out.println(arg0);
        System.out.println(arg1);
        try {
            servicios.DtPaquete _return = new servicios.DtPaquete();
            servicios.DtUniversal _returnContenido = null;
            _return.setContenido(_returnContenido);
            java.util.List<java.lang.String> _returnListaAux = new java.util.ArrayList<java.lang.String>();
            java.lang.String _returnListaAuxVal1 = "_returnListaAuxVal-1986357093";
            _returnListaAux.add(_returnListaAuxVal1);
            _return.getListaAux().addAll(_returnListaAux);
            java.util.List<servicios.DtUniversal> _returnListaDt = new java.util.ArrayList<servicios.DtUniversal>();
            servicios.DtUniversal _returnListaDtVal1 = null;
            _returnListaDt.add(_returnListaDtVal1);
            _return.getListaDt().addAll(_returnListaDt);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see servicios.Publicador#responderComentario(java.lang.String arg0, javax.xml.datatype.XMLGregorianCalendar arg1, java.lang.String arg2, java.lang.String arg3, java.lang.String arg4, int arg5)*
     */
    public void responderComentario(java.lang.String arg0, javax.xml.datatype.XMLGregorianCalendar arg1, java.lang.String arg2, java.lang.String arg3, java.lang.String arg4, int arg5) {
        LOG.info("Executing operation responderComentario");
        System.out.println(arg0);
        System.out.println(arg1);
        System.out.println(arg2);
        System.out.println(arg3);
        System.out.println(arg4);
        System.out.println(arg5);
        try {
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see servicios.Publicador#agregarVideoLista(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, boolean arg4)*
     */
    public void agregarVideoLista(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, boolean arg4) throws InvalidDataException_Exception,  DuplicateClassException_Exception   {
        LOG.info("Executing operation agregarVideoLista");
        System.out.println(arg0);
        System.out.println(arg1);
        System.out.println(arg2);
        System.out.println(arg3);
        System.out.println(arg4);
        try {
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new InvalidDataException_Exception("InvalidDataException...");
        //throw new DuplicateClassException_Exception("DuplicateClassException...");
    }

    /* (non-Javadoc)
     * @see servicios.Publicador#getListaDtVideo(java.lang.String arg0)*
     */
    public servicios.DtPaquete getListaDtVideo(java.lang.String arg0) {
        LOG.info("Executing operation getListaDtVideo");
        System.out.println(arg0);
        try {
            servicios.DtPaquete _return = new servicios.DtPaquete();
            servicios.DtUniversal _returnContenido = null;
            _return.setContenido(_returnContenido);
            java.util.List<java.lang.String> _returnListaAux = new java.util.ArrayList<java.lang.String>();
            java.lang.String _returnListaAuxVal1 = "_returnListaAuxVal1656483640";
            _returnListaAux.add(_returnListaAuxVal1);
            _return.getListaAux().addAll(_returnListaAux);
            java.util.List<servicios.DtUniversal> _returnListaDt = new java.util.ArrayList<servicios.DtUniversal>();
            servicios.DtUniversal _returnListaDtVal1 = null;
            _returnListaDt.add(_returnListaDtVal1);
            _return.getListaDt().addAll(_returnListaDt);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see servicios.Publicador#getDtUsuario(java.lang.String arg0)*
     */
    public servicios.DtPaquete getDtUsuario(java.lang.String arg0) {
        LOG.info("Executing operation getDtUsuario");
        System.out.println(arg0);
        try {
            servicios.DtPaquete _return = new servicios.DtPaquete();
            servicios.DtUniversal _returnContenido = null;
            _return.setContenido(_returnContenido);
            java.util.List<java.lang.String> _returnListaAux = new java.util.ArrayList<java.lang.String>();
            java.lang.String _returnListaAuxVal1 = "_returnListaAuxVal-672197069";
            _returnListaAux.add(_returnListaAuxVal1);
            _return.getListaAux().addAll(_returnListaAux);
            java.util.List<servicios.DtUniversal> _returnListaDt = new java.util.ArrayList<servicios.DtUniversal>();
            servicios.DtUniversal _returnListaDtVal1 = null;
            _returnListaDt.add(_returnListaDtVal1);
            _return.getListaDt().addAll(_returnListaDt);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}
