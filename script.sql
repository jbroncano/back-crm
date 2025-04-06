CREATE TABLE public.admi_rol (
	id_rol numeric NOT NULL,
	nombre varchar NOT NULL,
	descripcion varchar NOT NULL,
	estado varchar NOT NULL,
	CONSTRAINT admi_rol_pk PRIMARY KEY (id_rol)
);

CREATE TABLE public.admi_producto (
	id_producto numeric NOT NULL,
	nombre varchar NOT NULL,
	descripcion varchar NULL,
	precio decimal NULL;
	estado varchar NULL,
	CONSTRAINT admi_producto_pk PRIMARY KEY (id_producto)
);

CREATE TABLE public.info_persona (
	id_persona numeric NOT NULL,
	identificacion varchar NOT NULL,
	nombre varchar NULL,
	apellido varchar NULL,
	direccion varchar NULL,
	estado varchar NULL,
	razon_social varchar NULL,
	rol_id numeric NULL,
	CONSTRAINT info_persona_pk PRIMARY KEY (id_persona),
	CONSTRAINT info_persona_admi_rol_fk FOREIGN KEY (rol_id) REFERENCES public.admi_rol(id_rol)
);


CREATE TABLE public.info_usuario (
	id_usuario numeric NOT NULL,
	usuario varchar NOT NULL,
	"password" varchar NOT NULL,
	estado varchar NULL,
	persona_id numeric NOT NULL,
	CONSTRAINT info_usuario_pk PRIMARY KEY (id_usuario),
	CONSTRAINT info_usuario_info_persona_fk FOREIGN KEY (persona_id) REFERENCES public.info_persona(id_persona)
);

CREATE TABLE public.proforma_cab (
	id_proforma_cab numeric NOT NULL,
	numero varchar NOT NULL,
	fe_validez timestamp NOT NULL,
	condicion_pago varchar NOT NULL,
	forma_pago varchar NOT NULL,
	persona_id numeric NOT NULL,
	estado varchar NOT NULL,
	impuesto decimal NULL;
	descuento decimal NULL;
	CONSTRAINT proforma_cab_pk PRIMARY KEY (id_proforma_cab),
	CONSTRAINT proforma_cab_info_persona_fk FOREIGN KEY (persona_id) REFERENCES public.info_persona(id_persona)
);


CREATE TABLE public.proforma_det (
	id_proforma_det numeric NOT NULL,
	proforma_cab_id numeric NOT NULL,
	producto_id numeric NOT NULL,
	cantidad varchar NOT NULL,
	estado varchar NOT NULL,
	CONSTRAINT proforma_det_pk PRIMARY KEY (id_proforma_det),
	CONSTRAINT proforma_det_proforma_cab_fk FOREIGN KEY (proforma_cab_id) REFERENCES public.proforma_cab(id_proforma_cab),
	CONSTRAINT proforma_det_admi_producto_fk FOREIGN KEY (producto_id) REFERENCES public.admi_producto(id_producto)
);


CREATE TABLE public.proforma_cab_historial (
	proforma_cab_historial_id numeric NOT NULL,
	proforma_cab_id numeric NULL,
	estado_actual varchar NULL,
	nuevo_estado varchar NULL,
	observacion varchar NULL,
	usr_creacion varchar NULL,
	fe_creacion varchar NULL,
	CONSTRAINT proforma_cab_historial_pk PRIMARY KEY (proforma_cab_historial_id),
	CONSTRAINT proforma_cab_historial_proforma_cab_fk FOREIGN KEY (proforma_cab_id) REFERENCES public.proforma_cab(id_proforma_cab)
);

-- === Secuencia para admi_rol ===
CREATE SEQUENCE public.admi_rol_seq START 1 INCREMENT 1;
ALTER TABLE public.admi_rol 
ALTER COLUMN id_rol SET DEFAULT nextval('public.admi_rol_seq');

-- === Secuencia para admi_producto ===
CREATE SEQUENCE public.admi_producto_seq START 1 INCREMENT 1;
ALTER TABLE public.admi_producto 
ALTER COLUMN id_producto SET DEFAULT nextval('public.admi_producto_seq');

-- === Secuencia para info_persona ===
CREATE SEQUENCE public.info_persona_seq START 1 INCREMENT 1;
ALTER TABLE public.info_persona 
ALTER COLUMN id_persona SET DEFAULT nextval('public.info_persona_seq');

-- === Secuencia para info_usuario ===
CREATE SEQUENCE public.info_usuario_seq START 1 INCREMENT 1;
ALTER TABLE public.info_usuario 
ALTER COLUMN id_usuario SET DEFAULT nextval('public.info_usuario_seq');

-- === Secuencia para proforma_cab ===
CREATE SEQUENCE public.proforma_cab_seq START 1 INCREMENT 1;
ALTER TABLE public.proforma_cab 
ALTER COLUMN id_proforma_cab SET DEFAULT nextval('public.proforma_cab_seq');

-- === Secuencia para proforma_det ===
CREATE SEQUENCE public.proforma_det_seq START 1 INCREMENT 1;
ALTER TABLE public.proforma_det 
ALTER COLUMN id_proforma_det SET DEFAULT nextval('public.proforma_det_seq');

-- === Secuencia para proforma_cab_historial ===
CREATE SEQUENCE public.proforma_cab_historial_seq START 1 INCREMENT 1;
ALTER TABLE public.proforma_cab_historial 
ALTER COLUMN proforma_cab_historial_id SET DEFAULT nextval('public.proforma_cab_historial_seq');







