package factory;

public enum SingleAdminFacada {
    INSTACE;

    private AdminFacada facada = new AdminFacada();

    public AdminFacada getFacada() {
        return this.facada;
    }
}
